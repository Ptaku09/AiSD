package src.lab12.graph;

import src.lab12.disjointSet.DisjointSet;

import java.util.*;

public class Graph implements MyGraph {
    private final Map<Node, List<Edge>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    @Override
    public void addVertex(Node v) {
        adjacencyList.putIfAbsent(v, new ArrayList<>());
    }

    @Override
    public void addEdge(Node v1, Node v2, int weight) {
        Edge edge1 = new Edge(v1, v2, weight);
        Edge edge2 = new Edge(v2, v1, weight);

        adjacencyList.get(v1).add(edge1);
        adjacencyList.get(v2).add(edge2);
    }

    @Override
    public void resetVerticesState() {
        for (var entry : adjacencyList.entrySet()) {
            entry.getKey().unvisit();
            entry.getKey().setDistance(Integer.MAX_VALUE);
        }
    }

    @Override
    public List<Node> getNodes() {
        return new ArrayList<>(adjacencyList.keySet());
    }

    @Override
    public List<Edge> getEdges() {
        List<Edge> edges = new ArrayList<>();

        for (var entry : adjacencyList.entrySet())
            edges.addAll(entry.getValue());

        return edges;
    }

    @Override
    public List<Edge> getNeighbours(Node node) {
        return adjacencyList.get(node);
    }

    @Override
    public List<Edge> kruskal() {
        List<Edge> minimumSpanningTree = new LinkedList<>();
        List<Edge> edges = getEdges();
        DisjointSet ds = new DisjointSet(getNodes().size());

        for (Node node : getNodes())
            ds.makeSet(node.getIndex());

        edges.sort(Comparator.comparingInt(Edge::weight));

        for (Edge edge : edges)
            if (ds.findSet(edge.source().getIndex()) != ds.findSet(edge.destination().getIndex())) {
                ds.union(edge.source().getIndex(), edge.destination().getIndex());
                minimumSpanningTree.add(edge);
                printEdges(minimumSpanningTree);
            }

        return minimumSpanningTree;
    }

    @Override
    public List<Edge> prim(Node start) {
        List<Edge> minimumSpanningTree = new LinkedList<>();
        List<Node> nodes = getNodes();
        List<Edge> edges = getEdges();
        List<Node> temp = new LinkedList<>();

        start.setDistance(0);
        temp.add(start);

        for (Edge edge : edges)
            if (edge.source().getValue() == start.getValue())
                edge.destination().setDistance(edge.weight());

        while (temp.size() != nodes.size()) {
            int min = Integer.MAX_VALUE;
            Node minNode = null;

            for (Node node : nodes)
                if (!temp.contains(node) && node.getDistance() < min) {
                    min = node.getDistance();
                    minNode = node;
                }

            final int finalMin = min;
            adjacencyList.get(minNode).forEach(edge -> {
                if (edge.weight() == finalMin)
                    minimumSpanningTree.add(edge);

                if (!temp.contains(edge.destination()))
                    edge.destination().setDistance(Math.min(edge.destination().getDistance(), edge.weight()));
            });

            temp.add(minNode);
            printEdges(minimumSpanningTree);
        }

        return minimumSpanningTree;
    }

    private static void printEdges(List<Edge> minimumSpanningTree) {
        for (Edge edge : minimumSpanningTree)
            System.out.printf("%s%d%s%d%-2s", "(", edge.source().getValue(), "; ", edge.destination().getValue(), ")");

        System.out.println();
    }
}

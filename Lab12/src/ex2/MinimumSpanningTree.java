package ex2;

import disjointSet.DisjointSet;
import graph.Edge;
import graph.Graph;
import graph.Node;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MinimumSpanningTree {
    public static void kruskal(Graph graph) {
        List<Edge> minimumSpanningTree = new LinkedList<>();
        List<Edge> edges = graph.getEdges();
        DisjointSet ds = new DisjointSet(graph.getNodes().size() + 1);

        for (Node node : graph.getNodes())
            ds.makeSet(node.getValue());

        edges.sort(Comparator.comparingInt((Edge e) -> e.weight()));

        for (Edge edge : edges)
            if (ds.findSet(edge.source().getValue()) != ds.findSet(edge.destination().getValue())) {
                ds.union(edge.source().getValue(), edge.destination().getValue());
                minimumSpanningTree.add(edge);
                printEdges(minimumSpanningTree);
            }
    }

    public static void prim(Graph graph, Node start) {
        List<Edge> minimumSpanningTree = new LinkedList<>();
        List<Node> nodes = graph.getNodes();
        List<Edge> edges = graph.getEdges();
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

            for (Edge edge : edges) {
                assert minNode != null;
                // FRAGMENT ONLY FOR VISUALIZATION PURPOSES - finding edge
                if (edge.destination().getValue() == minNode.getValue() && edge.weight() == min)
                    minimumSpanningTree.add(edge);

                if (edge.source().getValue() == minNode.getValue() && !temp.contains(edge.destination()))
                    edge.destination().setDistance(Math.min(edge.destination().getDistance(), edge.weight()));
            }

            temp.add(minNode);
            printEdges(minimumSpanningTree);
        }
    }

    private static void printEdges(List<Edge> minimumSpanningTree) {
        for (Edge edge : minimumSpanningTree)
            System.out.printf("%s%d%s%d%-2s", "(", edge.source().getValue(), "; ", edge.destination().getValue(), ")");

        System.out.println();
    }
}

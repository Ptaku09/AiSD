package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}

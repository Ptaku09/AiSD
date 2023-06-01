package src.lab12.graph;

import java.util.List;

public interface MyGraph {
    void addVertex(Node v);

    void addEdge(Node v1, Node v2, int weight);

    List<Edge> getNeighbours(Node node);

    void resetVerticesState();

    List<Node> getNodes();

    List<Edge> getEdges();

    List<Edge> kruskal();

    List<Edge> prim(Node node);
}

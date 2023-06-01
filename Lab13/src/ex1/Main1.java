package ex1;

import ex1.graph.Graph;
import ex1.graph.Node;

public class Main1 {
    public static void main(String[] args) {
        Graph graph = new Graph();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);

        graph.addVertex(node1);
        graph.addVertex(node2);
        graph.addVertex(node3);
        graph.addVertex(node4);
        graph.addVertex(node5);
        graph.addVertex(node6);
        graph.addVertex(node7);
        graph.addVertex(node8);
        graph.addVertex(node9);
        graph.addVertex(node10);

        graph.addEdge(node1, node2, 2);
        graph.addEdge(node1, node8, 10);
        graph.addEdge(node1, node4, 5);
        graph.addEdge(node2, node5, 7);
        graph.addEdge(node2, node6, 1);
        graph.addEdge(node3, node7, 13);
        graph.addEdge(node3, node8, 6);
        graph.addEdge(node4, node9, 8);
        graph.addEdge(node4, node10, 15);
        graph.addEdge(node5, node10, 9);
        graph.addEdge(node10, node1, 4);
        graph.addEdge(node7, node2, 3);
        graph.addEdge(node9, node3, 11);
        graph.addEdge(node5, node6, 12);
        graph.addEdge(node8, node9, 3);

        System.out.println("Dijkstra's algorithm:");
        PathFinder.dijkstra(graph, node7);
    }
}

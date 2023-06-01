package ex1;

import ex1.graph.Edge;
import ex1.graph.Graph;
import ex1.graph.Node;

import java.util.LinkedList;
import java.util.List;

public class PathFinder {
    public static void dijkstra(Graph graph, Node start) {
        List<Node> nodes = graph.getNodes();
        List<Edge> edges = graph.getEdges();
        List<Node> temp = new LinkedList<>();

        graph.resetVerticesState();
        start.setDistance(0);
        temp.add(start);

        // FRAGMENT ONLY FOR VISUALIZATION PURPOSES
        printNodes(nodes);

        for (Edge edge : edges)
            if (edge.source().getValue() == start.getValue())
                edge.destination().setDistance(edge.weight());

        // FRAGMENT ONLY FOR VISUALIZATION PURPOSES
        printNodes(nodes);

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
                if (edge.source().getValue() == minNode.getValue() && !temp.contains(edge.destination()))
                    edge.destination().setDistance(Math.min(edge.destination().getDistance(), edge.weight() + minNode.getDistance()));
            }

            temp.add(minNode);
            
            // FRAGMENT ONLY FOR VISUALIZATION PURPOSES
            printNodes(nodes);
        }
    }

    private static void printNodes(List<Node> nodes) {
        System.out.printf("%-7s%-7s%n", "Node", "Distance");

        for (Node node : nodes)
            System.out.printf("%-7d%-7d%n", node.getValue(), node.getDistance());

        System.out.println();
    }
}

package ex1;

import graph.Edge;
import graph.Graph;
import graph.MyGraph;
import graph.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Search {
    public static void bfs(Graph graph, Node node) {
        if (node == null) return;

        List<Node> result = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        System.out.printf("%-10s%-10s%n", "current", "queue <-");

        while (!queue.isEmpty()) {
            Node current = queue.remove();

            if (current.isVisited()) continue;

            current.visit();
            result.add(current);
            System.out.printf("%-10d", current.getValue());
            printQueue(queue);

            ArrayList<Edge> neighboursLinks = (ArrayList<Edge>) graph.getNeighbours(current);

            if (neighboursLinks == null) continue;

            for (Edge neighbour : neighboursLinks)
                if (!neighbour.destination().isVisited() && !queue.contains(neighbour.destination()))
                    queue.add(neighbour.destination());
        }

        printResult(result);
        System.out.println();
    }

    private static void printQueue(Queue<Node> queue) {
        Queue<Node> temp = new LinkedList<>(queue);

        while (!temp.isEmpty()) {
            Node current = temp.remove();
            System.out.printf("%-3d", current.getValue());
        }

        System.out.println();
    }

    public static void dfs(MyGraph graph, Node node) {
        if (node == null) return;

        List<Node> result = new LinkedList<>();
        LinkedList<Node> stack = new LinkedList<>();
        stack.add(node);

        System.out.printf("%-10s%-10s%n", "current", "stack ->");

        while (!stack.isEmpty()) {
            Node current = stack.removeLast();

            if (current.isVisited()) continue;

            current.visit();
            result.add(current);
            System.out.printf("%-10d", current.getValue());
            printStack(stack);

            ArrayList<Edge> neighboursLinks = (ArrayList<Edge>) graph.getNeighbours(current);

            if (neighboursLinks == null) continue;

            for (int i = neighboursLinks.size() - 1; i >= 0; i--)
                if (!neighboursLinks.get(i).destination().isVisited() && !stack.contains(neighboursLinks.get(i).destination()))
                    stack.add(neighboursLinks.get(i).destination());
        }

        printResult(result);
        System.out.println();
    }

    private static void printStack(LinkedList<Node> stack) {
        for (Node node : stack)
            System.out.printf("%-3d", node.getValue());

        System.out.println();
    }

    private static void printResult(List<Node> result) {
        System.out.println("\nResult:");

        for (Node node : result)
            System.out.print(node.getValue() + " ");

        System.out.println();
    }
}

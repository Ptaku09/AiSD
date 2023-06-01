package ex2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectedGraphList implements Graph {
    private final Map<Integer, List<Integer>> adjacencyList;

    public DirectedGraphList(int n) {
        adjacencyList = new HashMap<>();
    }

    @Override
    public void addVertex(int v) {
        adjacencyList.putIfAbsent(v, new ArrayList<>());
    }

    @Override
    public void addEdge(int v1, int v2) {
        adjacencyList.get(v1).add(v2);
    }

    @Override
    public void showData() {
        for (var entry : adjacencyList.entrySet()) {
            System.out.print(entry.getKey() + " | ");

            for (var value : entry.getValue())
                System.out.print(value + " ");

            System.out.println();
        }
    }
}

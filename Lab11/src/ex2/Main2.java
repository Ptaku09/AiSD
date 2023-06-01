package ex2;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("-------------------------------------");
        System.out.println("Undirected Graph");
        System.out.println("-------------------------------------");

        System.out.printf("%n%-10s%n", "Matrix");
        UndirectedGraphMatrix undirectedGraphMatrix = new UndirectedGraphMatrix(0);
        test(undirectedGraphMatrix);

        System.out.printf("%-10s%n", "List");
        UndirectedGraphList undirectedGraphList = new UndirectedGraphList(5);
        test(undirectedGraphList);

        System.out.println("-------------------------------------");
        System.out.println("Directed Graph");
        System.out.println("-------------------------------------");

        System.out.printf("%n%-10s%n", "Matrix");
        DirectedGraphMatrix directedGraphMatrix = new DirectedGraphMatrix(0);
        test(directedGraphMatrix);

        System.out.printf("%-10s%n", "List");
        DirectedGraphList directedGraphList = new DirectedGraphList(5);
        test(directedGraphList);
    }

    private static void test(Graph graph) {
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdge(2, 3);
        graph.addEdge(0, 1);
        graph.addEdge(4, 3);
        graph.addEdge(3, 1);

        graph.showData();
        System.out.println();
    }
}

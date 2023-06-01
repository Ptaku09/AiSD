package ex2;

public class UndirectedGraphMatrix implements Graph {
    private final int[][] adjacencyMatrix;
    private int n;

    public UndirectedGraphMatrix(int n) {
        this.n = n;
        this.adjacencyMatrix = new int[10][10];
        int i, j;

        for (i = 0; i < n; i++)
            for (j = 0; j < n; j++)
                adjacencyMatrix[i][j] = 0;
    }

    @Override
    public void addVertex(int v) {
        int i;
        n++;

        for (i = 0; i < n; i++) {
            adjacencyMatrix[i][n - 1] = 0;
            adjacencyMatrix[n - 1][i] = 0;
        }
    }

    @Override
    public void addEdge(int x, int y) {
        adjacencyMatrix[x][y] = 1;
        adjacencyMatrix[y][x] = 1;
    }

    @Override
    public void showData() {
        System.out.printf("%-4s", "v");

        for (int i = 0; i < n; i++)
            System.out.print(i + " ");

        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print(i + " | ");

            for (int j = 0; j < n; j++)
                System.out.print(adjacencyMatrix[i][j] + " ");

            System.out.println();
        }
    }
}

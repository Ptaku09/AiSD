package ex1;

public class DisjointSetForest implements DisjointSet {
    private final int[] parent;
    private final int[] rank;

    public DisjointSetForest(int n) {
        parent = new int[n];
        rank = new int[n];
    }

    @Override
    public void makeSet(int x) {
        parent[x] = x;
        rank[x] = 0;
    }

    @Override
    public int findSet(int x) {
        if (parent[x] != x)
            parent[x] = findSet(parent[x]);

        return parent[x];
    }

    @Override
    public void union(int x, int y) {
        link(findSet(x), findSet(y));
    }

    @Override
    public void showData() {
        for (int i = 0; i < parent.length; i++)
            System.out.println(i + " is in set " + parent[i] + ", rank " + rank[i]);

        System.out.println();

        for (int i = 0; i < parent.length; i++)
            if (parent[i] == i) {
                System.out.print("Set " + i + ": ");

                for (int j = 0; j < parent.length; j++)
                    if (parent[j] == i)
                        System.out.print(j + " ");

                System.out.println();
            }

        System.out.println();

        for (int i : parent)
            System.out.print(i + " ");
    }

    private void link(int x, int y) {
        if (rank[x] > rank[y])
            parent[y] = x;
        else {
            parent[x] = y;

            if (rank[x] == rank[y])
                rank[y]++;
        }
    }
}

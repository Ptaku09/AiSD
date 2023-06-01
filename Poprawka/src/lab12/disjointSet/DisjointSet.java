package src.lab12.disjointSet;

public class DisjointSet implements MyDisjointSet {
    private final int[] parent;
    private final int[] rank;

    public DisjointSet(int n) {
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
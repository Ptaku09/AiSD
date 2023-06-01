package ex1;

public interface DisjointSet {
    void makeSet(int x);

    int findSet(int x);

    void union(int x, int y);

    void showData();
}

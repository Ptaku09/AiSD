package src.lab12.disjointSet;

public interface MyDisjointSet {
    void makeSet(int x);

    int findSet(int x);

    void union(int x, int y);
}

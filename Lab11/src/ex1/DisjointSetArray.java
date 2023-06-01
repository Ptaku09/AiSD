package ex1;

public class DisjointSetArray implements DisjointSet {
    private final int[] rep;

    public DisjointSetArray(int n) {
        rep = new int[n];
    }

    @Override
    public void makeSet(int x) {
        rep[x] = x;
    }

    @Override
    public int findSet(int x) {
        return rep[x];
    }

    @Override
    public void union(int x, int y) {
        int xRoot = findSet(x);
        int yRoot = findSet(y);

        if (xRoot == yRoot) return;

        for (int i = 0; i < rep.length; i++)
            if (rep[i] == yRoot)
                rep[i] = xRoot;
    }

    @Override
    public void showData() {
        for (int i = 0; i < rep.length; i++)
            System.out.println(i + " is in set " + rep[i]);

        System.out.println();

        for (int i = 0; i < rep.length; i++)
            if (rep[i] == i) {
                System.out.print("Set " + i + ": ");

                for (int j = 0; j < rep.length; j++)
                    if (rep[j] == i)
                        System.out.print(j + " ");

                System.out.println();
            }
    }
}

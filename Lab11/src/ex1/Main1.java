package ex1;

import java.util.Random;

public class Main1 {
    public static void main(String[] args) {
        DisjointSetArray disjointSetArray = new DisjointSetArray(10);
        DisjointSetForest disjointSetForest = new DisjointSetForest(10);

        test(disjointSetArray, disjointSetForest);
    }

    public static void test(DisjointSet dsa, DisjointSet dsf) {
        Random random = new Random();

        //Create disjoint set
        for (int i = 0; i < 10; i++) {
            dsa.makeSet(i);
            dsf.makeSet(i);
        }

//        for (int i = 0; i < 5; i++) {
//            int x = random.nextInt(10);
//            int y = random.nextInt(10);
//
//            dsa.union(x, y);
//            dsf.union(x, y);
//        }

        dsf.union(3, 4);
        dsf.union(5, 0);
        dsf.union(6, 0);
        dsf.union(4, 6);
        dsf.union(2, 1);
        dsf.union(7, 8);
        dsf.union(1, 8);
        dsf.union(5, 7);
        dsf.union(4, 5);

//        System.out.println("Disjoint set - array");
//        dsa.showData();

        System.out.println();

        System.out.println("Disjoint set - forest");
        dsf.showData();
    }
}

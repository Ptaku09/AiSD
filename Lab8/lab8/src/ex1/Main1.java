package ex1;

public class Main1 {
    public static void main(String[] args) {
        HashFunction linearHash = new LinearHash();
        HashFunction quadraticHash = new QuadraticHash();
        HashFunction doubleHash = new DoubleHash();

        System.out.println("LINEAR HASH");
        test(linearHash);

        System.out.println("QUADRATIC HASH");
        test(quadraticHash);

        System.out.println("DOUBLE HASH");
        test(doubleHash);
    }

    private static void test(HashFunction hashFunction) {
        HashTable ht = new HashTable(hashFunction);

        System.out.println("isEmpty: " + ht.isEmpty());
        System.out.println("size: " + ht.size());
        System.out.println();
        System.out.println("Current state:");
        ht.dump();

        //Add elements
        ht.put(123);
        ht.put(15435);
        ht.put(456);
        ht.put(789);
        ht.put(1334);
        ht.put(167);
        ht.put(673);
        ht.put(835);

        System.out.println();
        System.out.println("Current state:");
        ht.dump();

        //Add more elements
        ht.put(116);
        ht.put(957);
        ht.put(45);
        ht.put(61);
        ht.put(905);
        ht.put(345);
        ht.put(1465);
        ht.put(21);
        ht.put(693);

        System.out.println();
        System.out.println("Current state:");
        ht.dump();

        System.out.println();
        System.out.println("Get elements which does not exist (1): " + ht.get(1));
        System.out.println("Get elements which exists (345): " + ht.get(345));
        System.out.println("Check if table contains key, which does not exist (1): " + ht.containsKey(1));
        System.out.println("Check if table contains key, which exists (345): " + ht.containsKey(345));
        System.out.println("isEmpty: " + ht.isEmpty());
        System.out.println("size: " + ht.size());

        System.out.println();
        System.out.println("------------------------------------------------------------------------");
        System.out.println();
    }
}

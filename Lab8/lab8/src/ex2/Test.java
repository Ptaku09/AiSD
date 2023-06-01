package ex2;

import ex1.DoubleHash;
import ex1.HashFunction;
import ex1.LinearHash;
import ex1.QuadraticHash;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {
    private final List<Integer> elementsInHashTable = new ArrayList<>();
    private final List<Integer> elementsNotInHashTable = new ArrayList<>();
    private final Random random = new Random();
    private HashFunction[] hashFunctions;
    private double[] maxCapacities;

    public Test() {
        setupTests();
    }

    public void runTests() {
        for (HashFunction hf : hashFunctions)
            for (double mc : maxCapacities)
                test(hf, mc);
    }

    private void setupTests() {
        hashFunctions = new HashFunction[]{new LinearHash(), new QuadraticHash(), new DoubleHash()};
        maxCapacities = new double[]{0.65, 0.8, 0.95};
        generateElements();
    }

    private void generateElements() {
        generateElementsInHashTable();
        generateElementsNotInHashTable();
    }

    private void generateElementsInHashTable() {
        for (int i = 0; i < 999; i++)
            elementsInHashTable.add(random.nextInt(100, 100000));
    }

    private void generateElementsNotInHashTable() {
        for (int i = 0; i < 500; i++)
            elementsNotInHashTable.add(random.nextInt(100001, 200000));
    }

    private void test(HashFunction hf, double maxCapacity) {
        HashTableTest table = new HashTableTest(999, hf, maxCapacity);
        int missedTries = 0;
        int foundedTries = 0;
        int j = 0;

        for (Integer i : elementsInHashTable) {
            table.put(i);

            if (table.isFull())
                break;
        }

        while (j < 500) {
            missedTries += table.get(elementsNotInHashTable.get(j));

            //(int) (maxCapacity * 1000 - 1) - j  ->  to see difference between hash functions and maxCapacity
            //we must search for elements that are not on their base position (hash function has been run more than once time)
            foundedTries += table.get(elementsInHashTable.get((int) (maxCapacity * 1000 - 1) - j));
            j++;
        }

        System.out.println(hf.toString());
        System.out.println("alpha = " + maxCapacity);
        System.out.println("Founded tries: " + Math.round(foundedTries / 500.0 * 100) / 100.0);
        System.out.println("Missed tries: " + Math.round(missedTries / 500.0 * 100) / 100.0);
        System.out.println("Average tries: " + Math.round((foundedTries + missedTries) / 1000.0 * 100) / 100.0);
        System.out.println();
    }
}

package ex2;

import ex1.HashFunction;
import ex1.HashTable;

//slightly modified HashTable from ex1
//'put' method not extending table size
//'get' method returns number of tries
public class HashTableTest extends HashTable {
    private final double maxCapacity;

    public HashTableTest(int size, HashFunction hashFunction, double maxCapacity) {
        super(size, hashFunction);
        this.maxCapacity = maxCapacity;
    }

    @Override
    public void put(int el) {
        int index = hashFunction.hash(el) % arr.length;

        while (arr[index] != 0)
            index = hashFunction.hash(el) % arr.length;

        arr[index] = el;
        hashFunction.reset();
        amountOfElements++;
    }

    @Override
    public int get(int key) {
        int index = hashFunction.hash(key) % arr.length;
        int tries = 1;

        while (arr[index] != 0) {
            if (arr[index] == key) break;

            index = hashFunction.hash(key) % arr.length;
            tries++;
        }

        hashFunction.reset();
        return tries;
    }

    public boolean isFull() {
        return amountOfElements / (double) arr.length >= maxCapacity;
    }
}
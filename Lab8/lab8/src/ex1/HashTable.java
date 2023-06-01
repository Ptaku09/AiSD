package ex1;

public class HashTable {
    protected static final int INITIAL_SIZE = 17;
    protected final HashFunction hashFunction;
    protected int[] arr;
    protected int amountOfElements = 0;

    public HashTable(HashFunction hashFunction) {
        arr = new int[INITIAL_SIZE];
        this.hashFunction = hashFunction;
    }

    public HashTable(int size, HashFunction hashFunction) {
        arr = new int[size];
        this.hashFunction = hashFunction;
    }

    public void put(int el) {
        int index = hashFunction.hash(el) % arr.length;

        while (arr[index] != 0)
            index = hashFunction.hash(el) % arr.length;

        arr[index] = el;
        hashFunction.reset();
        amountOfElements++;

        if (amountOfElements / (double) arr.length > 0.7)
            resize();
    }

    public int get(int key) {
        int index = hashFunction.hash(key) % arr.length;

        while (arr[index] != 0) {
            if (arr[index] == key) break;

            index = hashFunction.hash(key) % arr.length;
        }

        hashFunction.reset();

        return arr[index] == key ? arr[index] : -1;
    }

    public boolean containsKey(int key) {
        int index = hashFunction.hash(key) % arr.length;

        while (arr[index] != 0) {
            if (arr[index] == key) break;

            index = hashFunction.hash(key) % arr.length;
        }

        hashFunction.reset();

        return arr[index] == key;
    }

    public int size() {
        return amountOfElements;
    }

    public boolean isEmpty() {
        return amountOfElements == 0;
    }

    public void dump() {
        for (int el : arr)
            if (el != 0)
                System.out.printf("%-8d", el);
            else
                System.out.printf("%-8s", "Empty");

        System.out.println();
    }

    private void resize() {
        int newSize = arr.length * 2;
        int[] currentArr = new int[arr.length];
        System.arraycopy(arr, 0, currentArr, 0, arr.length);

        amountOfElements = 0;
        arr = new int[newSize];

        for (int el : currentArr)
            if (el != 0)
                put(el);
    }
}
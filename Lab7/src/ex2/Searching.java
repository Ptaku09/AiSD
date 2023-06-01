package ex2;

import ex1.Heap;

public class Searching {
    private final int[] arr;
    private int linearComparisons = 0;
    private int binaryComparisons = 0;
    private boolean foundedBinary = false;

    public Searching(int[] arr) {
        this.arr = arr;
    }

    public int linearSearch(int key) {
        linearComparisons = 0;

        for (int i = 0; i < arr.length; i++)
            if (linearCompare(arr[i], key))
                return linearComparisons;

        return -1;
    }

    public int binarySearch(int key) {
        int left = 0;
        int right = arr.length - 1;
        binaryComparisons = 0;
        foundedBinary = false;

        // We will use heap and heapsort from ex1
        Heap heap = new Heap(arr);
        heap.sort();

        while (left <= right) {
            int mid = (left + right) / 2;
            int compare = binaryCompare(key, arr[mid]);

            if (compare == -1)
                right = mid - 1;
            else if (compare == 1)
                left = mid + 1;
            else {
                foundedBinary = true;
                return binaryComparisons;
            }
        }

        return binaryComparisons;
    }

    public boolean isFoundedBinary() {
        return foundedBinary;
    }

    private boolean linearCompare(int a, int b) {
        linearComparisons++;
        return a == b;
    }

    private int binaryCompare(int left, int right) {
        binaryComparisons++;

        if (left < right)
            return -1;
        else if (left == right)
            return 0;

        return 1;
    }
}

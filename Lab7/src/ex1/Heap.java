package ex1;

public class Heap {
    private final int[] heap;

    public Heap(int[] heap) {
        this.heap = heap;
    }

    public void heapAdjustment() {
        for (int i = (heap.length - 1) / 2; i >= 0; i--)
            sink(i, heap.length);
    }

    private void sink(int index, int n) {
        int indexOfBigger = 2 * index + 1;

        if (indexOfBigger < n) {
            if (indexOfBigger < n - 1 && heap[indexOfBigger] < heap[indexOfBigger + 1])
                indexOfBigger++;

            if (heap[index] < heap[indexOfBigger]) {
                swap(index, indexOfBigger);
                sink(indexOfBigger, n);
            }
        }
    }

    public void sort() {
        heapsort();
    }

    private void heapsort() {
        heapAdjustment();

        for (int i = heap.length - 1; i > 0; i--) {
            swap(0, i);
            sink(0, i);
        }
    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    public void display() {
        for (int j : heap) {
            System.out.print(j + " ");
        }

        System.out.printf("%n%n");
    }
}

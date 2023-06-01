package ex1;

import java.util.NoSuchElementException;

public class HeapPriorityQueue {
    private final static int DEFAULT_SIZE = 8;
    private final int[] heap;
    private int currentPosition = 0;

    public HeapPriorityQueue() {
        heap = new int[DEFAULT_SIZE];
    }

    public HeapPriorityQueue(int size) {
        heap = new int[size];
    }

    public void clear() {
        currentPosition = 0;
    }

    public void enqueue(int value) throws FullQueueException {
        if (currentPosition == heap.length)
            throw new FullQueueException();

        heap[currentPosition] = value;
        swim(currentPosition);
        currentPosition++;
    }

    public int dequeue() throws EmptyQueueException {
        if (currentPosition == 0)
            throw new EmptyQueueException();

        int result = heap[0];

        heap[0] = heap[--currentPosition];
        sink(0);

        return result;
    }

    public void changePriority(int index, int newPriority) throws NoSuchElementException {
        if (index >= currentPosition)
            throw new NoSuchElementException();

        heap[index] = newPriority;
        sink(index);
    }

    public void deleteElement(int index) throws NoSuchElementException {
        if (index >= currentPosition)
            throw new NoSuchElementException();

        heap[index] = heap[--currentPosition];
        sink(index);
    }

    public void display() {
        for (int i = 0; i < currentPosition; i++) {
            System.out.print(heap[i] + " ");
        }

        System.out.printf("%n%n");
    }

    private void sink(int index) {
        boolean isDone = false;
        int child;

        while (!isDone && (child = 2 * index + 1) < currentPosition) {
            if (child < currentPosition - 1 && heap[child] < heap[child + 1])
                child++;

            if (heap[index] < heap[child]) {
                swap(index, child);
                index = child;
            } else {
                isDone = true;
            }
        }
    }

    private void swim(int index) {
        int parent;

        while (index != 0 && heap[index] > heap[(parent = (index - 1) / 2)]) {
            swap(index, parent);
            index = parent;
        }
    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }
}

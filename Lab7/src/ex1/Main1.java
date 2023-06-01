package ex1;

public class Main1 {
    public static void main(String[] args) throws EmptyQueueException, FullQueueException {
        HeapPriorityQueue priorityQueue = new HeapPriorityQueue();

        priorityQueue.enqueue(4);
        priorityQueue.enqueue(5);
        priorityQueue.enqueue(10);
        priorityQueue.enqueue(7);
        priorityQueue.enqueue(6);
        priorityQueue.enqueue(9);
        priorityQueue.enqueue(12);
        priorityQueue.enqueue(1);

        System.out.println("Priority queue:");
        priorityQueue.display();

        System.out.println("After changing priority of index 0 to 2:");
        priorityQueue.changePriority(0, 2);
        priorityQueue.display();

        System.out.println("After deleting index 2:");
        priorityQueue.deleteElement(2);
        priorityQueue.display();

        System.out.println("After deleting index 0:");
        priorityQueue.deleteElement(0);
        priorityQueue.display();

        int res = priorityQueue.dequeue();
        System.out.println("Dequeued: " + res);
        priorityQueue.display();

        res = priorityQueue.dequeue();
        System.out.println("Dequeued: " + res);
        priorityQueue.display();

        res = priorityQueue.dequeue();
        System.out.println("Dequeued: " + res);
        priorityQueue.display();

        res = priorityQueue.dequeue();
        System.out.println("Dequeued: " + res);
        priorityQueue.display();

        res = priorityQueue.dequeue();
        System.out.println("Dequeued: " + res);
        priorityQueue.display();

        res = priorityQueue.dequeue();
        System.out.println("Dequeued: " + res);
        priorityQueue.display();

        System.out.println("------------------------");
        System.out.println("HEAP SORT");
        System.out.println("------------------------");
        System.out.println();
        Heap heap = new Heap(new int[]{2, 4, 6, 0, 8, 12, 321, 4, 6});

        System.out.println("Initial array:");
        heap.display();

        System.out.println("After sorting:");
        heap.sort();
        heap.display();
    }
}

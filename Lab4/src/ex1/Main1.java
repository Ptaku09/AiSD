package ex1;

public class Main1 {
    public static void main(String[] args) throws EmptyQueueException {
        ListQueue<String> queue = new ListQueue<>();

        System.out.println("Check if queue is empty:");
        System.out.println("Is empty: " + queue.isEmpty());
        System.out.println("Size: " + queue.size());
        System.out.println();

        //Add elements to queue
        queue.enqueue("Mateusz");
        System.out.println("Added: Mateusz");
        queue.enqueue("Piotr");
        System.out.println("Added: Piotr");
        queue.enqueue("Pawel");
        System.out.println("Added: Pawel");
        queue.enqueue("Adam");
        System.out.println("Added: Adam");
        queue.enqueue("Anna");
        System.out.println("Added: Anna");
        queue.enqueue("Maria");
        System.out.println("Added: Maria");
        System.out.println();

        System.out.println("Check if elements were added correctly:");
        System.out.println("Is empty: " + queue.isEmpty());
        System.out.println("Size: " + queue.size());
        System.out.println();

        System.out.println("Get first elements without removing:");
        System.out.println(queue.first());
        System.out.println();

        System.out.println("Check if element was not removed:");
        System.out.println("Is empty: " + queue.isEmpty());
        System.out.println("Size: " + queue.size());
        System.out.println();

        System.out.println("Dequeue elements:");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println();

        System.out.println("Check if elements were dequeued correctly:");
        System.out.println("Is empty: " + queue.isEmpty());
        System.out.println("Size: " + queue.size());
    }
}

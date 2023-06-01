package ex1;

public class FullQueueException extends Exception {
    public FullQueueException() {
        super("Queue is full");
    }
}

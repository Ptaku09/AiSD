package ex1;

public class ListQueue<E> {
    OneWayLinkedListWithHead<E> _list;

    public ListQueue() {
        _list = new OneWayLinkedListWithHead<>();
    }

    public boolean isEmpty() {
        return _list.isEmpty();
    }

    public boolean isFull() {
        return false;
    }

    public E dequeue() throws EmptyQueueException {
        E value = _list.remove(0);

        if (value == null)
            throw new EmptyQueueException();

        return value;
    }

    public void enqueue(E element) {
        _list.add(element);
    }

    public int size() {
        return _list.size();
    }

    public E first() throws EmptyQueueException {
        E value = _list.get(0);

        if (value == null)
            throw new EmptyQueueException();

        return value;
    }
}

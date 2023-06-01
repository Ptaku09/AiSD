package ex2;

import ex1.OneWayLinkedListWithHead;

import java.util.EmptyStackException;

public class ListStack<E> {
    OneWayLinkedListWithHead<E> _list;

    public ListStack() {
        _list = new OneWayLinkedListWithHead<>();
    }

    public boolean isEmpty() {
        return _list.isEmpty();
    }

    public boolean isFull() {
        return false;
    }

    public E pop() throws EmptyStackException {
        E value = _list.remove(0);

        if (value == null)
            throw new EmptyStackException();

        return value;
    }

    public void push(E element) {
        _list.add(0, element);
    }

    public int size() {
        return _list.size();
    }

    public E top() throws EmptyStackException {
        E value = _list.get(0);

        if (value == null)
            throw new EmptyStackException();

        return value;
    }
}

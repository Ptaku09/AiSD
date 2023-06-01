package ex4;

import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E> {
    private static final int DEFAULT_STACK_SIZE = 10;
    private final E[] arrayStack;
    private int topPosition = 0;
    private int elementsOnStack = 0;

    @SuppressWarnings("unchecked")
    public ArrayStack(int initialSize) {
        arrayStack = (E[]) new Object[initialSize];
    }

    public ArrayStack() {
        this(DEFAULT_STACK_SIZE);
    }

    @Override
    public boolean isEmpty() {
        return elementsOnStack == 0;
    }

    @Override
    public boolean isFull() {
        return elementsOnStack == arrayStack.length;
    }

    @Override
    public E pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();

        if (topPosition == 0) topPosition = arrayStack.length;

        E elementToReturn = arrayStack[--topPosition];
        arrayStack[topPosition] = null;
        elementsOnStack--;
        return elementToReturn;
    }

    @Override
    public void push(E elem) {
        if (topPosition == arrayStack.length) topPosition = 0;

        arrayStack[topPosition++] = elem;

        if (!isFull()) elementsOnStack++;
    }

    @Override
    public int size() {
        return elementsOnStack;
    }

    @Override
    public E top() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();

        if (topPosition == 0) topPosition = arrayStack.length;

        return arrayStack[topPosition - 1];
    }
}

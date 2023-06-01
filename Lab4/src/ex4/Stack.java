package ex4;

import java.util.EmptyStackException;

public interface Stack<T> {
    boolean isEmpty();

    boolean isFull();

    T pop() throws EmptyStackException;

    void push(T elem);

    int size();

    T top() throws EmptyStackException;
}
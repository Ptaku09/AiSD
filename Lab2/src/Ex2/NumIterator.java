package Ex2;

public interface NumIterator<T> {
    void first();

    void last();

    void next();

    void previous();

    boolean isDone();

    T current();
}

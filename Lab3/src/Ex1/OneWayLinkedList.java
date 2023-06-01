package Ex1;

public interface OneWayLinkedList<E> {
    boolean add(E e);

    boolean insert(int index, E e);

    E set(int index, E e);

    int indexOf(E e);

    boolean contains(E e);

    E get(int index);

    E removePos(int index);

    boolean removeVal(E e);

    E removeFirst();

    int size();

    boolean isEmpty();

    void clear();

    void display();
}

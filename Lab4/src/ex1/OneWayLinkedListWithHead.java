package ex1;

public class OneWayLinkedListWithHead<E> {
    private class Element {
        private E value;
        private Element next;

        public Element(E data) {
            value = data;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }
    }

    Element head = null;

    public OneWayLinkedListWithHead() {
    }

    public boolean add(E e) {
        Element newElement = new Element(e);

        if (head == null) {
            head = newElement;
            return true;
        }

        Element tail = head;
        while (tail.getNext() != null)
            tail = tail.getNext();

        tail.setNext(newElement);
        return true;
    }

    public boolean add(int index, E e) {
        if (index < 0)
            throw new IndexOutOfBoundsException();

        Element newElement = new Element(e);

        if (index == 0) {
            newElement.setNext(head);
            head = newElement;
            return true;
        }

        Element actualElement = head;

        for (int i = 0; i < index - 1; i++)
            actualElement = actualElement.getNext();

        newElement.setNext(actualElement.getNext());
        actualElement.setNext(newElement);
        return true;
    }

    public E get(int index) {
        Element actualElement = head;

        for (int i = 0; i < index; i++)
            actualElement = actualElement.getNext();

        return actualElement != null ? actualElement.getValue() : null;
    }

    public E remove(int index) {
        if (index < 0 || head == null)
            return null;

        if (index == 0) {
            E removedValue = head.getValue();
            head = head.getNext();

            return removedValue;
        }

        Element actualElement = head;

        for (int i = 0; i < index - 1; i++)
            actualElement = actualElement.getNext();

        E removedValue = actualElement.getNext().getValue();
        actualElement.setNext(actualElement.getNext().getNext());

        return removedValue;
    }

    public int size() {
        int size = 0;
        Element actualElement = head;

        while (actualElement != null) {
            size++;
            actualElement = actualElement.getNext();
        }

        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }
}

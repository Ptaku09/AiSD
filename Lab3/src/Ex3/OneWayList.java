package Ex3;

public class OneWayList<E> {
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

    public boolean add(E value) {
        Element newElement = new Element(value);

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

    public void display() {
        display(head);
    }

    public void displayReverse() {
        displayReverse(head);
    }

    private void display(Element node) {
        if (node == null)
            return;

        System.out.print(node.getValue() + " ");
        display(node.getNext());
    }

    private void displayReverse(Element node) {
        if (node == null)
            return;

        displayReverse(node.getNext());
        System.out.print(node.getValue() + " ");
    }

    public OneWayList<E> copy() {
        return copy(new OneWayList<>(), head);
    }

    private OneWayList<E> copy(OneWayList<E> list, Element node) {
        if (node == null)
            return list;

        list.add(node.getValue());
        return copy(list, node.getNext());
    }

    public int sumOfKeys() {
        return sumOfKeys(head);
    }

    private int sumOfKeys(Element node) {
        if (node == null)
            return 0;

        return sumOfKeys(node.getNext()) + (Integer) node.getValue();
    }

    public int size() {
        return size(head);
    }

    private int size(Element node) {
        if (node == null)
            return 0;

        return size(node.getNext()) + 1;
    }
}

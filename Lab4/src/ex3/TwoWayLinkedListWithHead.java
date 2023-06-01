package ex3;

public class TwoWayLinkedListWithHead<E> {
    private class Element {
        private E value;
        private Element next;
        private Element prev;

        Element(E value) {
            this.value = value;
        }

        public void insertAfter(Element element) {
            element.setNext(this.getNext());
            element.setPrev(this);
            this.getNext().setPrev(element);
            this.setNext(element);
        }

        public void insertBefore(Element element) {
            element.setNext(this);
            element.setPrev(this.getPrev());
            this.getPrev().setNext(element);
            this.setPrev(element);
        }

        public void remove() {
            this.getNext().setPrev(this.getPrev());
            this.getPrev().setNext(this.getNext());
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

        public Element getPrev() {
            return prev;
        }

        public void setPrev(Element prev) {
            this.prev = prev;
        }
    }

    Element head = null;

    public TwoWayLinkedListWithHead() {
    }

    private Element getElement(int index) {
        if (index < 0)
            throw new IndexOutOfBoundsException();

        Element element = head;
        int counter = 0;

        while (element != null && counter < index) {
            counter++;
            element = element.getNext();
        }

        if (element == null)
            throw new IndexOutOfBoundsException();

        return element;
    }

    public boolean add(E value) {
        Element newElement = new Element(value);

        if (head == null) {
            head = newElement;
            return true;
        }

        Element actualElement = head;

        while (actualElement.getNext() != null)
            actualElement = actualElement.getNext();

        actualElement.setNext(newElement);
        newElement.setPrev(actualElement);

        return true;
    }

    public void appendList(TwoWayLinkedListWithHead<E> list) {
        if (head == null) {
            head = list.head;
        } else {
            Element actualElement = head;

            while (actualElement.getNext() != null)
                actualElement = actualElement.getNext();

            actualElement.setNext(list.head);
            list.head.setPrev(actualElement);
        }
    }

    public void appendList(int index, TwoWayLinkedListWithHead<E> list) {
        Element actualElement = head;
        Element actualListElement = list.head;

        for (int i = 0; i < index - 1; i++)
            actualElement = actualElement.getNext();

        while (actualListElement.getNext() != null)
            actualListElement = actualListElement.getNext();

        actualListElement.setNext(actualElement.getNext());
        actualElement.setNext(list.head);
        list.head.setPrev(head);
        actualElement.setPrev(actualListElement);
    }

    public void display() {
        Element actualElement = head;

        if (actualElement != null)
            while (actualElement != null) {
                System.out.println(actualElement.getValue());
                actualElement = actualElement.getNext();
            }
    }
}

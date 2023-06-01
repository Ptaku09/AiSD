package src.lab3;

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

        public boolean equals(Object o) {
            if (this == o)
                return true;

            if (o == null || getClass() != o.getClass())
                return false;

            Element element = (Element) o;
            return value.equals(element.getValue());
        }
    }

    Element head;

    public OneWayLinkedListWithHead() {
        head = new Element(null);
        head.setNext(head);
    }

    public boolean add(E e) {
        Element newElement = new Element(e);

        if (head.getValue() == null) {
            head.setValue(e);
            newElement.setNext(newElement);

            return true;
        }

        Element tail = head;
        while (tail.getNext() != head)
            tail = tail.getNext();

        tail.setNext(newElement);
        newElement.setNext(head);

        return true;
    }

    public boolean insert(int index, E e) {
        Element actualElement = head;
        Element newElement = new Element(e);

        if (index == 0) {
            newElement.setNext(head);

            while (actualElement.getNext() != head)
                actualElement = actualElement.getNext();

            head = newElement;
            actualElement.setNext(newElement);

            return true;
        } else if (index > 0) {
            for (int i = 0; i < index - 1; i++)
                actualElement = actualElement.getNext();

            newElement.setNext(actualElement.getNext());
            actualElement.setNext(newElement);

            return true;
        }

        return false;
    }

    public E set(int index, E e) {
        Element actualElement = head;

        for (int i = 0; i < index; i++)
            actualElement = actualElement.getNext();

        E valueBeforeChange = actualElement.getValue();
        actualElement.setValue(e);

        return valueBeforeChange;
    }

    public int indexOf(E e) {
        Element actualElement = head.getNext();
        int index = 1;

        if (head.getValue().equals(e))
            return 0;

        while (actualElement != head) {
            if (actualElement.getValue().equals(e))
                return index;

            index++;
            actualElement = actualElement.getNext();
        }

        return -1;
    }

    public boolean contains(E e) {
        Element actualElement = head.getNext();

        if (head.getValue().equals(e))
            return true;

        while (actualElement != head) {
            if (actualElement.getValue().equals(e))
                return true;

            actualElement = actualElement.getNext();
        }

        return false;
    }

    public Element getEl(E e) {
        if (head.getValue() == null)
            return null;

        if (head.getValue().equals(e))
            return head;

        Element actualElement = head.getNext();

        while (actualElement != head) {
            if (actualElement.getValue().equals(e))
                return actualElement;

            actualElement = actualElement.getNext();
        }

        return null;
    }

    public E get(int index) {
        Element actualElement = head;

        for (int i = 0; i < index; i++)
            actualElement = actualElement.getNext();

        return actualElement.getValue();
    }

    public E removePos(int index) {
        Element actualElement = head;
        E deletedValue;

        if (index == 0 || index % size() == 0) {
            deletedValue = head.getValue();
            head = head.getNext();

            while (actualElement.getNext() != head)
                actualElement = actualElement.getNext();

            actualElement.setNext(head);
        } else {
            for (int i = 0; i < index - 1; i++)
                actualElement = actualElement.getNext();

            deletedValue = actualElement.getNext().getValue();
            actualElement.setNext(actualElement.getNext().getNext());
        }

        return deletedValue;
    }

    public boolean removeVal(E e) {
        Element actualElement = head;

        if (actualElement.getValue().equals(e)) {
            while (actualElement.getNext() != head)
                actualElement = actualElement.getNext();

            actualElement.setNext(head.getNext());
            head = head.getNext();
            return true;
        }

        while (actualElement.getNext() != head) {
            if (actualElement.getNext().getValue().equals(e)) {
                actualElement.setNext(actualElement.getNext().getNext());
                return true;
            }

            actualElement = actualElement.getNext();
        }

        return false;
    }

    public E removeElem(Element e) {
        if (head == null)
            return null;

        if (head.equals(e)) {
            E removedValue = head.getValue();
            Element tail = head;

            while (tail.getNext() != head)
                tail = tail.getNext();

            tail.setNext(head.getNext());
            head = head.getNext();

            return removedValue;
        }

        Element actualElement = head;

        while (actualElement.getNext() != head) {
            if (actualElement.getNext().equals(e)) {
                E removedValue = actualElement.getNext().getValue();
                actualElement.setNext(actualElement.getNext().getNext());

                return removedValue;
            }

            actualElement = actualElement.getNext();
        }

        return null;
    }

    public E removeFirst() {
        if (head == null)
            return null;

        Element actualElement = head;

        while (actualElement.getNext() != head)
            actualElement = actualElement.getNext();

        E removedValue = head.getValue();
        actualElement.setNext(head.getNext());
        head = head.getNext();

        return removedValue;
    }

    public int size() {
        int size = 1;
        Element actualElement = head;

        if (actualElement == null)
            return 0;

        actualElement = actualElement.getNext();

        while (actualElement != head) {
            size++;
            actualElement = actualElement.getNext();
        }

        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
    }

    public void display() {
        Element actualElement = head;

        if (actualElement == null)
            return;

        System.out.println(actualElement.getValue());

        actualElement = actualElement.getNext();

        while (actualElement != head) {
            System.out.println(actualElement.getValue());
            actualElement = actualElement.getNext();
        }

        System.out.println();
    }
}

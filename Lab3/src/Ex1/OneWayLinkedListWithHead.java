package Ex1;

public class OneWayLinkedListWithHead<E> implements OneWayLinkedList<E> {
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

        @Override
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

    @Override
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

    @Override
    public boolean insert(int index, E e) {
        Element actualElement = head;
        Element newElement = new Element(e);

        if (index == 0) {
            while (actualElement.getNext() != head)
                actualElement = actualElement.getNext();

            newElement.setNext(head);
            head = newElement;
            actualElement.setNext(newElement);
        } else {
            for (int i = 0; i < index - 1; i++)
                actualElement = actualElement.getNext();

            newElement.setNext(actualElement.getNext());
            actualElement.setNext(newElement);
        }

        return false;
    }

    @Override
    public E set(int index, E e) {
        Element actualElement = head;

        for (int i = 0; i < index; i++)
            actualElement = actualElement.getNext();

        E valueBeforeChange = actualElement.getValue();
        actualElement.setValue(e);

        return valueBeforeChange;
    }

    @Override
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

    @Override
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

    @Override
    public E get(int index) {
        Element actualElement = head;

        for (int i = 0; i < index; i++)
            actualElement = actualElement.getNext();

        return actualElement.getValue();
    }

    @Override
    public E removePos(int index) {
        if (index < 0 || head == null)
            return null;

        if (size() == 1) {
            E removedValue = head.getValue();
            head = null;

            return removedValue;
        }

        if (index == 0) {
            E removedValue = head.getValue();
            Element tail = head;

            while (tail.getNext() != head)
                tail = tail.getNext();

            tail.setNext(head.getNext());
            head = head.getNext();

            return removedValue;
        } else {
            Element actualElement = head;

            for (int i = 0; i < index - 1; i++)
                actualElement = actualElement.getNext();

            E removedValue = actualElement.getNext().getValue();

            if (actualElement.getNext().equals(head)) {
                actualElement.setNext(actualElement.getNext().getNext());
                head = actualElement.getNext();
                return removedValue;
            }

            actualElement.setNext(actualElement.getNext().getNext());

            return removedValue;
        }
    }

    @Override
    public boolean removeVal(E e) {
        if (head == null)
            return false;

        if (head.getValue().equals(e)) {
            if (size() == 1) {
                head = null;
                return true;
            }

            Element tail = head;

            while (tail.getNext() != head)
                tail = tail.getNext();

            tail.setNext(head.getNext());

            head = head.getNext();
            return true;
        } else {
            Element actualElement = head;

            while (actualElement.getNext() != head) {
                if (actualElement.getNext().getValue().equals(e)) {
                    actualElement.setNext(actualElement.getNext().getNext());
                    return true;
                }

                actualElement = actualElement.getNext();
            }

            return false;
        }
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

    @Override
    public E removeFirst() {
        if (head.getValue() == null)
            return null;

        Element actualElement = head;

        while (actualElement.getNext() != head)
            actualElement = actualElement.getNext();

        E removedValue = head.getValue();
        actualElement.setNext(head.getNext());
        head = head.getNext();

        return removedValue;
    }

    @Override
    public int size() {
        if (head.getValue() == null)
            return 0;

        Element actualElement = head.getNext();
        int size = 1;

        while (actualElement != head) {
            size++;
            actualElement = actualElement.getNext();
        }

        return size;
    }

    @Override
    public boolean isEmpty() {
        return head.getValue() == null;
    }

    @Override
    public void clear() {
        head.setValue(null);
        head.setNext(head);
    }

    @Override
    public void display() {
        Element actualElement = head;

        for (int i = 0; i < size(); i++) {
            System.out.println(actualElement.getValue());
            actualElement = actualElement.getNext();
        }

        System.out.println();
    }
}

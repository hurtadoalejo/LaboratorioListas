import java.util.Iterator;

public class DoublyList<T> implements Iterable<T> {
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int size;

    public DoublyList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public DoubleNode<T> getHead() {
        return head;
    }

    public DoubleNode<T> getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    public void add(T data, int index) {
        DoubleNode<T> newNode = new DoubleNode<>(data);

        if (size == 0) {
            head = tail = newNode;
            size++;
            return;
        }
        if (index == 0) {
            addFirst(newNode);
            size++;
            return;
        }
        if (index == size) {
            addLast(newNode);
            size++;
            return;
        }
        size++;
        add(newNode, index);
    }

    private void addFirst(DoubleNode<T> newNode) {
        newNode.setNext(head);
        head.setPrev(newNode);
        head = newNode;
    }

    private void addLast(DoubleNode<T> newNode) {
        tail.setNext(newNode);
        newNode.setPrev(tail);
        tail = newNode;
    }

    private void add(DoubleNode<T> newNode, int index) {
        DoubleNode<T> current;

        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
        } else {
            current = tail;
            for (int i = size - 1; i >= index; i--) {
                current = current.getPrev();
            }
        }

        newNode.setPrev(current.getPrev());
        newNode.setNext(current);
        current.getPrev().setNext(newNode);
        current.setPrev(newNode);
    }

    public void remove() {
        if (head == null) return;

        head = head.getNext();
        if (head != null) {
            head.setPrev(null);
        } else {
            tail = null;
        }

        size--;
    }

    public T getFirst() {
        if (head == null) return null;
        return head.getData();
    }

    public T getLast() {
        if (tail == null) return null;
        return tail.getData();
    }

    public T get(int index) {
        if (index < 0 || index >= size) return null;

        DoubleNode<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.getPrev();
            }
        }

        return current.getData();
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new DoublyIterator();
    }

    public void removeAfter(int index) {
        if (index < 0 || index >= size) return;
        DoubleNode<T> temp = head;
        int i = 0;
        while (i < index) {
            temp = temp.getNext();
            i++;
        }
        temp.setNext(null);
        tail = temp;
        size = index + 1;
    }

    private class DoublyIterator implements Iterator<T> {
        private DoubleNode<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (current == null) return null;
            T data = current.getData();
            current = current.getNext();
            return data;
        }
    }
}
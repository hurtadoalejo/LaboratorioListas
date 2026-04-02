import java.util.Iterator;

public class CircularSimplyList<T> implements Iterable<T> {
    private Node<T> head;
    private int size;

    public CircularSimplyList() {
        this.head = null;
        this.size = 0;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void add(T data, int index) {
        if (index < 0 || index > size) return;
        Node<T> newNode = new Node<>(data);

        if (size == 0) {
            head = newNode;
            head.setNext(head);
            size++;
            return;
        }
        if (index == 0) {
            Node<T> tail = head;
            while (tail.getNext() != head) {
                tail = tail.getNext();
            }
            newNode.setNext(head);
            head = newNode;
            tail.setNext(head);
            size++;
            return;
        }
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        size++;
    }

    public boolean remove(T data) {
        if (size == 0) return false;

        if (head.getData().equals(data)) {
            return removeFirst();
        }

        Node<T> current = head.getNext();
        Node<T> previous = head;

        while (current != head) {
            if (current.getData().equals(data)) {
                previous.setNext(current.getNext());
                size--;
                return true;
            }
            previous = current;
            current = current.getNext();
        }
        return false;
    }

    private boolean removeFirst() {
        if (size == 1) {
            head = null;
        } else {
            Node<T> tail = head;
            while (tail.getNext() != head) {
                tail = tail.getNext();
            }
            head = head.getNext();
            tail.setNext(head);
        }
        size--;
        return true;
    }

    public T get(int index) {
        if (index < 0 || index >= size) return null;
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleIterator();
    }

    private class SimpleIterator implements Iterator<T> {
        private Node<T> current = head;
        private int count = 0;

        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public T next() {
            if (current == null) return null;
            T data = current.getData();
            current = current.getNext();
            count++;
            return data;
        }
    }
}
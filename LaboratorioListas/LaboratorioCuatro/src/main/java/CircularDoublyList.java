import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularDoublyList<T> implements Iterable<T>{
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int size;

    public CircularDoublyList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    public DoubleNode<T> getHead() {
        return head;
    }

    public void setHead(DoubleNode<T> head) {
        this.head = head;
    }

    public DoubleNode<T> getTail() {
        return tail;
    }

    public void setTail(DoubleNode<T> tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) return null;
        if (size == 1) return head.getData();

        return findNode(index).getData();
    }

    public void add(T data, int index) {
        if (index < 0 || index > size) return;

        DoubleNode<T> node = new DoubleNode<>(data);

        if (size == 0) {
            addEmptyList(node);
            return;
        }
        if (index == 0) {
            addFirstList(node);
            return;
        }
        if (index == size) {
            addLastList(node);
            return;
        }
        DoubleNode<T> current = findNode(index);

        node.setNext(current);
        node.setPrev(current.getPrev());
        current.getPrev().setNext(node);
        current.setPrev(node);
        size++;
    }

    private void addEmptyList(DoubleNode<T> node) {
        head = node;
        tail = node;
        node.setNext(node);
        node.setPrev(node);
        size++;
    }

    private void addFirstList(DoubleNode<T> node) {
        node.setNext(head);
        head.setPrev(node);
        tail.setNext(node);
        node.setPrev(tail);
        head = node;
        size++;
    }

    private void addLastList(DoubleNode<T> node) {
        node.setNext(head);
        node.setPrev(tail);
        tail.setNext(node);
        head.setPrev(node);
        tail = node;
        size++;
    }

    public boolean remove(T data) {
        if (size == 0) return false;
        DoubleNode<T> node = head;
        int count = 0;

        while (count < size) {
            if (node.getData().equals(data)) {
                if (size == 1) {
                    head = null;
                    tail = null;
                } else {
                    node.getPrev().setNext(node.getNext());
                    node.getNext().setPrev(node.getPrev());
                    updateHeadTail(node);
                }

                size--;
                return true;
            }
            node = node.getNext();
            count++;
        }

        return false;
    }

    private void updateHeadTail(DoubleNode<T> node) {
        if (node == head) head = node.getNext();
        if (node == tail) tail = node.getPrev();
    }

    private DoubleNode<T> findNode(int index) {
        DoubleNode<T> node;
        if (index > size / 2) {
            node = tail;
            for (int i = size-1; i > index; i--) {
                node = node.getPrev();
            }
        } else {
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
        }
        return node;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new CircularIterator();
    }

    private class CircularIterator implements Iterator<T> {
        private DoubleNode<T> current = head;
        private int count = 0;

        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T data = current.getData();
            current = current.getNext();
            count++;
            return data;
        }
    }
}

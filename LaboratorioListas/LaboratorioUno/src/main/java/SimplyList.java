import java.util.Iterator;

public class SimplyList<T> implements Iterable<T> {
    private Node<T> head;
    private int size;

    public SimplyList() {
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

    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void remove() {
        if (head != null) head = head.next;
        size--;
    }

    public T getFirst() {
        if (head == null) return null;
        return head.data;
    }

    public T getSecond() {
        if (head == null || head.next == null) {
            return null;
        }

        return head.next.data;
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

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (current == null) return null;
            T data = current.data;
            current = current.next;
            return data;
        }
    }
}
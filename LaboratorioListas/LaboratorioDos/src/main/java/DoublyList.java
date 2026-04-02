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
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    private void addLast(DoubleNode<T> newNode) {
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    private void add(DoubleNode<T> newNode, int index) {
        DoubleNode<T> current;

        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i >= index; i--) {
                current = current.prev;
            }
        }

        newNode.prev = current.prev;
        newNode.next = current;
        current.prev.next = newNode;
        current.prev = newNode;
    }

    public void remove() {
        if (head == null) return;

        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }

        size--;
    }

    public T getFirst() {
        if (head == null) return null;
        return head.data;
    }

    public T getLast() {
        if (tail == null) return null;
        return tail.data;
    }

    public T get(int index) {
        if (index < 0 || index >= size) return null;

        DoubleNode<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }

        return current.data;
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
            temp = temp.next;
            i++;
        }
        temp.next = null;
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
            T data = current.data;
            current = current.next;
            return data;
        }
    }
}
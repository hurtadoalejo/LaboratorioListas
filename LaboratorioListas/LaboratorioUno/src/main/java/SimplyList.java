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

    /*
    Añade un elemento al final de la lista
     */
    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    /*
    Elimina el primer elemento de la lista
     */
    public void remove() {
        if (head != null) head = head.getNext();
        size--;
    }

    /*
    Retorna el primer elemento si existe
     */
    public T getFirst() {
        if (head == null) return null;
        return head.getData();
    }

    /*
    Retorna el segundo elemento si existe
     */
    public T getSecond() {
        if (head == null || head.getNext() == null) {
            return null;
        }

        return head.getNext().getData();
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
            T data = current.getData();
            current = current.getNext();
            return data;
        }
    }
}
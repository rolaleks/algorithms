import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<T> extends LinkedLists<T> implements Iterable<T> {

    DoubleLinkedNode<T> first;
    DoubleLinkedNode<T> last;


    @Override
    protected DoubleLinkedNode<T> createNode(T value) {
        return new DoubleLinkedNode<T>(value);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    @Override
    public void insertFirst(T value) {
        DoubleLinkedNode<T> newNode = createNode(value);
        newNode.next = first;
        if (isEmpty()) {
            last = newNode;
        } else {
            first.prev = newNode;
        }
        first = newNode;
        size++;
    }

    public void insertLast(T value) {
        DoubleLinkedNode<T> newNode = createNode(value);
        if (isEmpty()) {
            first = newNode;
        } else {
            newNode.prev = last;
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        DoubleLinkedNode<T> oldLast = last;
        if (last.prev != null) {
            last.prev.next = null;
        } else {
            first = null;
        }
        last = last.prev;
        size--;
        return oldLast.value;
    }

    @Override
    public void insert(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            insertFirst(value);
            return;
        }
        if (index == size) {
            insertLast(value);
            return;
        }

        DoubleLinkedNode current = first;
        int i = 0;
        while (i < index - 1) {
            current = current.next;
            i++;
        }
        DoubleLinkedNode newNode = new DoubleLinkedNode(value);
        newNode.next = current.next;
        newNode.prev = current;
        current.next = newNode;
        newNode.next.prev = newNode;
        size++;
    }

    @Override
    public boolean remove(T value) {
        if (isEmpty()) {
            return false;
        }
        if (first.value.equals(value)) {
            removeFirst();
            return true;
        }
        DoubleLinkedNode current = first;
        while (current != null && !current.value.equals(value)) {
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        if (current == last) {
            removeLast();
            return true;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
        return true;
    }

    @Override
    public DoubleLinkedNode<T> getFirstNode() {
        return first;
    }

    public T getLast() {
        return (T) last.value;
    }

    private class Iter implements Iterator<T> {
        DoubleLinkedNode current = first;

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public T next() {
            current = current.next;
            return (T) current.value;
        }
    }
}

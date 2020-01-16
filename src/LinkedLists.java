import org.w3c.dom.Node;

import java.util.ArrayList;

public class LinkedLists<T> {

    LinkedNode<T> first;
    int size = 0;

    protected LinkedNode<T> createNode(T value) {
        return new LinkedNode<T>(value);
    }

    public void insertFirst(T value) {
        LinkedNode<T> node = createNode(value);
        node.setNext(first);
        first = node;
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        LinkedNode<T> node = first;
        first = first.next;
        size--;
        return node.value;
    }

    public void insert(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            insertFirst(value);
            return;
        }
        LinkedNode current = first;
        int i = 0;
        while (i < index - 1) {
            current = current.next;
            i++;
        }
        LinkedNode newNode = new LinkedNode(value);
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    public boolean remove(T value) {
        if (isEmpty()) {
            return false;
        }
        if (first.value.equals(value)) {
            removeFirst();
            return true;
        }
        LinkedNode current = first;
        while (current.next != null && !current.next.value.equals(value)) {
            current = current.next;
        }
        if (current.next == null) {
            return false;
        }
        current.next = current.next.next;

        size--;
        return true;
    }

    public int indexOf(T value) {
        return index(value);
    }

    private int index(T value) {
        LinkedNode current = first;
        int index = 0;
        while (current != null) {
            if (current.value.equals(value)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(T value) {
        return index(value) > -1;
    }

    public T getFirst() {
        return (T) first.value;
    }

    public LinkedNode<T> getFirstNode() {
        return first;
    }

    public boolean isEmpty() {
        return getFirstNode() == null;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {

        if (this.isEmpty()) {
            return "[]";
        }

        ArrayList<String> strs = new ArrayList<>();
        LinkedNode<T> current = getFirstNode();
        do {
            strs.add(current.value.toString());
            current = current.getNext();


        } while (current != null);

        return "[ " + String.join(", ", strs) + " ] ";
    }

}

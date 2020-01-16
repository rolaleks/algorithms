import java.util.EmptyStackException;

public class MyLinkedStack<T> {

    private DoubleLinkedList<T> stack = new DoubleLinkedList<>();

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void add(T value) {
        stack.insertLast(value);
    }

    public T remove() {
        return stack.removeLast();
    }

    public T peak() {
        return stack.getLast();
    }

}

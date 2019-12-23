import java.util.EmptyStackException;

public class MyStack<T> extends BaseArray<T> {


    public void add(T value) {
        if (size == capacity) {
            increaseCapacity();
        }
        this.array[size] = value;
        size++;
    }

    public T remove() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T v = array[size - 1];
        array[size - 1] = null;
        size--;
        return v;
    }

    public T peak() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[size - 1];
    }
}

import java.util.EmptyStackException;

public class MyQueue<T> extends BaseArray<T> {

    protected int begin;
    protected int end;

    public MyQueue() {
        super();
        begin = 0;
        end = -1;
    }

    public void add(T value) {
        if (size == capacity) {
            increaseCapacity();
        }
        int next = nextIndex(end);
        this.array[next] = value;
        end = next;
        size++;
    }

    public T remove() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T v = array[begin];
        array[begin] = null;
        size--;
        begin = nextIndex(begin);
        return v;
    }

    protected void increaseCapacity() {
        this.capacity *= 2;
        T[] arr = (T[]) new Object[capacity];
        for (int i = begin; i < this.array.length; i++) {
            arr[i] = this.array[i];
        }
        if (end < begin) {
            for (int i = 0; i < end; i++) {
                arr[i] = this.array[i];
            }
        }
        begin = 0;
        end = size-1;
        this.array = arr;
    }

    public T peak() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[begin];
    }

    protected int nextIndex(int index) {
        return (index + 1) % array.length;
    }
}

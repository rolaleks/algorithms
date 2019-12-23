import java.util.AbstractMap;
import java.util.EmptyStackException;
import java.util.HashMap;

public class PriorityQueue<T> extends MyQueue<T> {
    protected AbstractMap.SimpleEntry<Integer, T>[] array;

    public PriorityQueue() {
        capacity = 1;
        size = 0;
        this.array = new AbstractMap.SimpleEntry[capacity];
    }


    public void add(T value, int priority) {
        if (size == capacity) {
            increaseCapacity();
        }
        int next = nextIndex(end);
        this.array[next] = new AbstractMap.SimpleEntry<Integer, T>(priority, value);
        end = next;
        size++;
        int i = end;
        while ((prevIndex(i + 1) > begin || prevIndex(i + 1) < begin) && array[prevIndex(i)].getKey() > array[prevIndex(i + 1)].getKey()) {
            i--;
            swap(prevIndex(i), prevIndex(i + 1));
        }
    }

    public void add(T value) {
        this.add(value, 1);
    }

    public T remove() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        AbstractMap.SimpleEntry<Integer, T> v = array[begin];
        array[begin] = null;
        size--;
        begin = nextIndex(begin);
        return v.getValue();
    }

    protected void increaseCapacity() {
        this.capacity *= 2;
        AbstractMap.SimpleEntry<Integer, T>[] arr = new AbstractMap.SimpleEntry[capacity];
        for (int i = begin; i < this.array.length; i++) {
            arr[i] = this.array[i];
        }
        if (end < begin) {
            for (int i = 0; i < end; i++) {
                arr[i] = this.array[i];
            }
        }
        begin = 0;
        end = size - 1;
        this.array = arr;
    }

    protected int prevIndex(int index) {

        if (index <= 0) {
            index = array.length - index;
        }

        return (index - 1) % array.length;
    }

    protected int nextIndex(int index) {
        return (index + 1) % array.length;
    }

    protected void swap(int i1, int i2) {
        AbstractMap.SimpleEntry<Integer, T> tmp = this.array[i1];
        this.array[i1] = this.array[i2];
        this.array[i2] = tmp;
    }
}

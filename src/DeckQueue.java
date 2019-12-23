import java.util.EmptyStackException;

public class DeckQueue<T> extends MyQueue<T> {

    public void addBegin(T value) {
        if (size == capacity) {
            increaseCapacity();
        }
        int prevIndex = prevIndex(begin);
        this.array[prevIndex] = value;
        begin = prevIndex;
        size++;
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T v = array[end];
        array[end] = null;
        size--;
        end = prevIndex(end);
        return v;
    }

    protected int prevIndex(int index) {

        if (index <= 0) {
            index = array.length - index;
        }

        return (index - 1) % array.length;
    }
}

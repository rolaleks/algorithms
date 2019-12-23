public class BaseArray<T> {
    protected T[] array;
    protected int capacity;
    protected int size;

    public BaseArray() {
        capacity = 1;
        size = 0;
        this.array = (T[]) new Object[capacity];
    }

    protected void increaseCapacity() {
        this.capacity *= 2;
        T[] arr = (T[]) new Object[capacity];
        for (int i = 0; i < this.array.length; i++) {
            arr[i] = this.array[i];
        }
        this.array = arr;
    }

    public void clear() {
        this.size = 0;
    }

    protected void swap(int i1, int i2) {
        T tmp = this.array[i1];
        this.array[i1] = this.array[i2];
        this.array[i2] = tmp;
    }

    public void print() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.array[i] + " ");
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}

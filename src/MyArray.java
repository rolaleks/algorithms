import java.util.Random;

public class MyArray {

    private int[] array;
    private int capacity;
    private int size;

    public MyArray() {
        this.capacity = 100;
        this.size = 0;
        this.array = new int[capacity];
    }

    public void generateNumbers(int size) {
        Random r = new Random();
        clear();
        for (int i = 0; i < size; i++) {
            this.add(r.nextInt());
        }
    }

    public void add(int value) {
        if (size >= capacity) {
            increaseCapacity();
        }
        this.array[size] = value;
        size++;
    }

    /**
     * @param value
     * @return индекс первого попавшегося элемента если не найден то -1
     */
    public int findElement(int value) {
        for (int i = 0; i < this.size; i++) {
            if (this.array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void removeByValue(int value) {
        int index = this.findElement(value);
        if (index >= 0) {
            remove(index);
        }
    }

    public void removeByIndex(int index) {
        if (index >= 0 && index < size) {
            remove(index);
        }
    }

    public void remove(int index) {
        for (int i = index; i < (this.size - 1); i++) {

            this.array[i] = this.array[i + 1];
        }
        size--;
    }

    public void clear() {
        this.size = 0;
    }

    public void sortSelect() {
        int minElIndex;
        for (int i = 0; i < this.size; i++) {
            minElIndex = i;
            for (int j = i + 1; j < this.size; j++) {
                if (this.array[j] < this.array[minElIndex]) {
                    minElIndex = j;
                }
            }
            if (minElIndex != i) {
                swap(minElIndex, i);
            }
        }
    }

    public void sortInsert() {

        int j;
        for (int i = 1; i < this.size; i++) {
            int tmp = this.array[i];
            j = i;
            while (j > 0 && this.array[j - 1] >= tmp) {
                this.array[j] = this.array[j - 1];
                j--;
            }
            if (j != i)
                this.array[j] = tmp;
        }


    }

    public void sortBubble() {
        boolean isSwapped;
        for (int i = this.size - 1; i > 0; i--) {
            isSwapped = false;
            for (int j = 0; j < i; j++) {
                if (this.array[j] > this.array[j + 1]) {
                    isSwapped = true;
                    swap(j, j + 1);
                }
            }
            if (!isSwapped) {
                break;
            }
        }
    }

    private void swap(int i1, int i2) {
        int tmp = this.array[i1];
        this.array[i1] = this.array[i2];
        this.array[i2] = tmp;
    }

    private void increaseCapacity() {
        this.capacity *= 2;
        int[] arr = new int[capacity];
        for (int i = 0; i < this.array.length; i++) {
            arr[i] = this.array[i];
        }
        this.array = arr;
    }

    public void print() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.array[i] + " ");
        }
        System.out.println();
    }
}

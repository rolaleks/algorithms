public class Lesson {


    public static void main(String[] args) {
        MyArray arr = new MyArray();

        int size = 1000000;
        long time;
        arr.generateNumbers(size);
        time = System.currentTimeMillis();
        arr.sortSelect();
        System.out.println("Сортировка выбором время:" + (System.currentTimeMillis() - time));
        arr.generateNumbers(size);
        time = System.currentTimeMillis();
        arr.sortBubble();
        System.out.println("Сортировка пузырьком время:" + (System.currentTimeMillis() - time));
        arr.generateNumbers(size);
        time = System.currentTimeMillis();
        arr.sortInsert();
        System.out.println("Сортировка вставкой время:" + (System.currentTimeMillis() - time));
    }
}


import java.util.Random;

public class Main {
    public static void main(String[] args) {

        ChainingHashMap<Integer, Integer> chainingHashMap = new ChainingHashMap<>();
        LinearProbingHashMap<Integer, Integer> linearProbingHashMap = new LinearProbingHashMap<>();

        Random random = new Random();
        for (int i = 0; i < 400; i+=4) {
            int randInt = random.nextInt(100);
            chainingHashMap.put(randInt, randInt);
            linearProbingHashMap.put(i, i);
        }
        System.out.println("ChainingHashMap");
        System.out.println("Размер до " + chainingHashMap.size());
        for (int i = 0; i < 10; i++) {
            int randInt = random.nextInt(100);
            System.out.println("Пробуем удалить элемент с индексом: " + randInt);
            boolean status = chainingHashMap.remove(randInt);
            if (status) {
                System.out.println("Элемент удален");
            } else {
                System.out.println("Элемент не найден");
            }
        }
        System.out.println("Размер после " + chainingHashMap.size());

        System.out.println("LinearProbingHashMap");

        System.out.println("Размер до " + linearProbingHashMap.size());
        for (int i = 0; i < 10; i++) {
            int randInt = random.nextInt(100);
            System.out.println("Индекс: " + randInt + " существует: " + linearProbingHashMap.contains(randInt));
            System.out.println("Пробуем удалить элемент с индексом: " + randInt);
            boolean status = linearProbingHashMap.remove(randInt);
            if (status) {
                System.out.println("Элемент удален");
            } else {
                System.out.println("Элемент не найден");
            }
        }

        System.out.println("Размер после " + linearProbingHashMap.size());
        //Проверяем что все элементы находятся
        int count = 0;
        for (int i = 0; i < 400; i+=4) {

            count += linearProbingHashMap.contains(i) ? 1 : 0;
        }
        System.out.println("Найдено элементов " + count);
        if(count == linearProbingHashMap.size()){
            System.out.println("Удаление работает верно");
        }
        System.out.println(linearProbingHashMap);
    }


}

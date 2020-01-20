import java.util.Random;

public class Lesson {
    public static void main(String[] args) {

        Random random = new Random();
        int balancedCount = 0;
        int notBalancedCount = 0;
        for (int i = 0; i < 20000; i++) {
            MyTree tree = new MyTree();
            while (tree.maxLevel() < 6) {
                int key = random.nextInt(201) - 100;
                tree.put(key, key);
            }
            if (tree.isBalanced()) {
                balancedCount++;
            } else {
                notBalancedCount++;
            }
        }

        float percent = ((float) balancedCount / (balancedCount + notBalancedCount)) * 100;

        System.out.println("Процент сбалансированных:" + percent);
    }
}

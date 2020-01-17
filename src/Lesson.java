public class Lesson {

    public static void main(String[] args) {
        System.out.println(Pow.calculate(2, 10));
        System.out.println(Pow.calculate(5, 7));

        Pack pack = new Pack(125);
        pack.addItem(5, 20);
        pack.addItem(50, 55);
        pack.addItem(80, 100);
        System.out.println(pack.calculate(true));
        pack.info();
        System.out.println(pack.calculate(false));
        pack.info();
    }
}

public class Pow {
    public static float calculate(float a, int b) {


        if (b == 1) {
            return a;
        } else if (b == 2) {
            return a * a;
        } else if (b == 0) {
            return 1;
        } else if (b < 0) {
            throw new ArithmeticException();
        }

        int del = b % 2;
        int newB = (b - del) / 2;
        float subResult = calculate(a, newB);
        subResult *= subResult;
        if (del == 1) {
            subResult *= a;
        }
        return subResult;
    }
}

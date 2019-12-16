package lesson;

import java.util.*;
import java.io.*;

public class Main {
    PrintWriter pw;
    Scanner sc;

    public static void main(String[] argv) throws IOException {
        new Main().run839();
    }

    public void run001() throws IOException {
        sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        pw = new PrintWriter(System.out);
        pw.print(a + b);
        pw.close();
    }


    public void run630() throws IOException {
        int[][] tubes = {
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 0, 0},
                {1, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 1, 1, 0},
        };

        sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        int[][] map = new int[a][b];
        for (int j = 0; j < a; j++) {
            for (int k = 0; k < b; k++) {
                map[j][k] = 0;
            }
        }
        pw = new PrintWriter(System.out);
        boolean added;
        boolean valid;
        int count = 0;
        double maxCount = Math.pow(6, a * b);
        int addedA = 0;
        int addedB = 0;
        int invalidA = 0;
        int invalidB = 0;
        System.out.println(maxCount);
        for (int i = 0; i < maxCount; i++) {

            added = false;
            valid = true;
            for (int j = 0; j < a; j++) {
                for (int k = 0; k < b; k++) {
                    if (!added) {
                        if (map[j][k] < 5) {
                            map[j][k]++;
                            addedA = j;
                            addedB = k;
                            added = true;
                            break;
                        } else {
                            map[j][k] = 0;
                        }
                    }
                }
                if (added) {
                    break;
                }
            }

            for (int j = 0; j < a; j++) {
                if (!valid) {
                    break;
                }
                invalidA = j;
                for (int k = 0; k < b; k++) {
                    invalidB = k;
                    if (j == 0 && tubes[map[j][k]][0] == 1) {
                        valid = false;
                        break;
                    } else if (j == (a - 1) && tubes[map[j][k]][2] == 1) {
                        valid = false;
                        break;
                    }
                    if (k == 0 && tubes[map[j][k]][3] == 1) {
                        valid = false;
                        break;
                    } else if (k == (b - 1) && tubes[map[j][k]][1] == 1) {
                        valid = false;
                        break;
                    }
                    if (j > 0 && (tubes[map[j][k]][0] != tubes[map[j - 1][k]][2])) {
                        valid = false;
                        break;
                    }
                    if (j < a - 1 && (tubes[map[j][k]][2] != tubes[map[j + 1][k]][0])) {
                        valid = false;
                        break;
                    }
                    if (k > 0 && (tubes[map[j][k]][3] != tubes[map[j][k - 1]][1])) {
                        valid = false;
                        break;
                    }
                    if (k < b - 1 && (tubes[map[j][k]][1] != tubes[map[j][k + 1]][3])) {
                        valid = false;
                        break;
                    }

                }


            }
            if (valid) {
                count++;
            } else {
                double plus = Math.pow(6, (invalidA * b) + invalidB);
                i += (plus - 1);

                for (int j = 0; j <= invalidA; j++) {
                    for (int k = 0; k < b; k++) {
                        if (j < invalidA || k < invalidB) {
                            map[j][k] = 5;
                        }
                    }
                }
            }
        }
        pw.print(count);
        pw.close();
    }


    public void run069() throws IOException {

        sc = new Scanner(System.in);
        pw = new PrintWriter(System.out);
        int t1 = 0;
        int t2 = 0;
        for (int i = 0; i < 4; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            t1 += a;
            t2 += b;
        }


        if (t1 < t2) {
            pw.print("2");
        } else if (t1 > t2) {
            pw.print("1");
        } else {
            pw.print("DRAW");
        }

        pw.close();
    }


    public void run949() throws IOException {

        sc = new Scanner(System.in);
        pw = new PrintWriter(System.out);
        int n = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();

        int n1 = a;
        int n2 = b;
        int prev = a;
        for (int i = n; i > 0; i--) {

            if (i == 2) {
                n2 = prev;
            } else if (i == 1) {
                n1 = prev;
            }
            a = prev;
            prev = b - prev;
            b = a;
        }

        pw.print(n1 + " " + n2);

        pw.close();
    }


    public void run839() throws IOException {

        sc = new Scanner(System.in);
        pw = new PrintWriter(System.out);
        String s = sc.nextLine();

        boolean b = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                b = false;
                break;
            }
        }

        if (b) {
            pw.print("YES");
        } else {
            pw.print("NO");
        }


        pw.close();
    }
}

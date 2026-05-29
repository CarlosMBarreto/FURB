package unit5.list7;

import java.util.Scanner;

public class Uni5Exe31 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            int n = sc.nextInt();

            for (int i = 2; n > 1; i++) {
                while (n % i == 0) {
                    System.out.println(n + " / " + i);
                    n /= i;
                }
            }
        }
    }
}
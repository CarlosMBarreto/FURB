package list7;

import java.util.Scanner;

public class Uni5Exe01 {

    public static void main(String[] args) {

        int n;

        try (Scanner sc = new Scanner(System.in)) {
            for (int i = 0; i < 20; i++) {
                n = sc.nextInt();

                if (n % 2 == 0) {
                    System.out.println("Par");
                } else {
                    System.out.println("Ímpar");
                }
            }
        }
    }
}

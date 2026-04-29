package list7;

import java.util.Scanner;

public class Uni5Exe03 {

    public static void main(String[] args) {

        int soma = 0;

        try (Scanner sc = new Scanner(System.in)) {
            for (int i = 0; i < 100; i++) {
                soma += 1 / i;
            }
            System.out.println("Soma: " + soma);
        }
    }
}

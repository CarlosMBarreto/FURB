package list7;

import java.util.Scanner;

public class Uni5Exe20 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            double massa = sc.nextDouble();
            int tempo = 0;

            while (massa >= 0.0005) {
                massa /= 2;
                tempo += 50;
            }

            System.out.println("Tempo: " + tempo);
            System.out.println("Massa final: " + massa);
        }
    }
}
package unit3.list4;

import java.util.Scanner;

public class Exe1016 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            final int velocidadeX = 60;
            final int velocidadeY = 90;

            int km = sc.nextInt();

            int resultado = km * 2;

            System.out.println(resultado + " minutos");

        }
    }
}

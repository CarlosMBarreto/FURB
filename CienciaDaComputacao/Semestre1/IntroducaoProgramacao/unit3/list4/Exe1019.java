package unit3.list4;

import java.util.Scanner;

public class Exe1019 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            int tempo = sc.nextInt();

            int horas = tempo / 3600;
            tempo = tempo % 3600;

            int minutos = tempo / 60;
            tempo = tempo % 60;

            int segundos = tempo / 1;
            tempo = tempo % 1;

            System.out.println(horas + ":" + minutos + ":" + segundos);
        }
    }
}

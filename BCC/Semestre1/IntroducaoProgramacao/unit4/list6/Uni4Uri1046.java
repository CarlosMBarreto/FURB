package unit4.list6;

import java.util.Scanner;

public class Uni4Uri1046 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            int horaInicial = sc.nextInt();
            int horaFinal = sc.nextInt();

            if (horaInicial < horaFinal) {
                System.out.println("O JOOGO DUROU " + (horaFinal - horaInicial) + " HORA(S)");
            } else if(horaFinal <= horaInicial) {
                System.out.println("O JOGO DUROU " + (24 - horaInicial + horaFinal) + " HORA(S)");
            }
        }
    }
}

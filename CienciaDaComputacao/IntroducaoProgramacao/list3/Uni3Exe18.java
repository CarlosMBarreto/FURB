package list3;

import java.util.Scanner;

public class Uni3Exe18 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Distância: ");
            double distancia = sc.nextDouble();

            System.out.print("Tempo (min): ");
            double minutos = sc.nextDouble();

            double tempoHora = minutos / 60;
            double velocidadeMedia = distancia / tempoHora;
            double ritmoMedio = minutos / distancia;

            System.out.println("Tempo em horas: " + tempoHora);
            System.out.println("Velocidade média: " + velocidadeMedia + " km/h");
            System.out.println("Ritmo médio: " + ritmoMedio + " min/km");
        }
    }
}

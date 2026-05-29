package unit3.list2;

import java.util.Scanner;

public class Uni3Exe14 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            final double consumoCombustivel = 12;

            System.out.print("Distância: ");
            double distancia = sc.nextDouble();

            System.out.print("Tempo: ");
            double tempo = sc.nextDouble();

            double velocidade = distancia / tempo;

            System.out.println("A velocidade média foi de " + velocidade + " km/h" + " e a quantidade de combustível usado foi " + (distancia / consumoCombustivel) + " litros");

        }
    }
}

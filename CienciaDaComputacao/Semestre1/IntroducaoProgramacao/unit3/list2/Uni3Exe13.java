package unit3.list2;

import java.util.Scanner;

public class Uni3Exe13 {
    public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) {

            final double azulejoEstampado = 12.5;
            final double metroQuadrado = 9;

            System.out.print("Altura: ");
            double alturaParede = sc.nextDouble();
            System.out.print("Comprimento: ");
            double comprimentoParede = sc.nextDouble();

            double valorMetroQuadradoParede = azulejoEstampado * metroQuadrado;

            double valorFinal = valorMetroQuadradoParede * (alturaParede * comprimentoParede);

            System.out.println("O valor final é R$" + valorFinal);
        }
    }
}

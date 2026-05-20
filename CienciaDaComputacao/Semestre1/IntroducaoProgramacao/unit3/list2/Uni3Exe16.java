package unit3.list2;

import java.util.Scanner;

public class Uni3Exe16 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Valor total da compra: ");
            int valorTotal = sc.nextInt();

            System.out.print("Total dado pelo cliente: ");
            int totalDado = sc.nextInt();

            int troco = totalDado - valorTotal;

            int qtdNotas100 = troco / 100;
            int qtdnotas10 = (troco / 10) % 10;
            int qtdNotas1 = troco % 10;

            int qtdNotas = qtdNotas100 + qtdnotas10 + qtdNotas1;

            System.out.println("O número mínimo de notas de troco é: " + qtdNotas);

        }
    }
}

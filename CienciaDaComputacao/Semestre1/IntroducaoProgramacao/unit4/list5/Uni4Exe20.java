package unit4.list5;

import java.util.Scanner;

public class Uni4Exe20 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Nota 1:");
            double n1 = sc.nextDouble();

            System.out.print("Nota 2:");
            double n2 = sc.nextDouble();

            System.out.print("Nota 3:");
            double n3 = sc.nextDouble();

            System.out.print("Média em exercícios:");
            double ex = sc.nextDouble();

            double media = (n1 + n2 * 2 + n3 * 3 + ex) / 7;

            String conceito = "";

            String situacao = "";

            if (media >= 9.0) {
                conceito = "A";
                situacao = "Aprovado";
            } else if (media >= 7.5 && media < 9.0) {
                conceito = "B";
                situacao = "Aprovado";
            } else if (media >= 6.0 && media < 7.5) {
                conceito = "C";
                situacao = "Aprovado";
            } else if (media >= 4.0 && media < 6.0) {
                conceito = "D";
                situacao = "Reprovado";
            } else if (media < 4) {
                conceito = "E";
                situacao = "Reprovado";
            }

            System.out.printf("A média de aproveitamento foi: %.2f \nConceito: %s. %s", media, conceito, situacao);
        }
    }
}

package list7;

import java.util.Scanner;

public class Uni5Exe15 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Nome do aluno: ");
            String nome = sc.nextLine();

            while (!nome.equalsIgnoreCase("fim")) {

                System.out.print("Nota 1: ");
                double n1 = sc.nextDouble();

                System.out.print("Nota 2: ");
                double n2 = sc.nextDouble();
                sc.nextLine(); // limpar buffer

                double media = (n1 + n2) / 2;

                System.out.printf("Média de %s: %.2f\n", nome, media);

                System.out.print("\nNome do aluno: ");
                nome = sc.nextLine();
            }
        }
    }
}
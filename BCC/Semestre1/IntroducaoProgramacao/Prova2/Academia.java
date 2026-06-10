package Prova2;

import java.util.Scanner;

public class Academia {

    public class Prova2 {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            int n = 0;

            while (n < 1 || n > 50) {
                System.out.print("Quantidade de alunos: ");
                n = sc.nextInt();
                if (n < 1 || n > 50) {
                    System.out.println("Quantidade de alunos inválida.");
                }
            }

            String nomeAluno[] = new String[n];
            double pesoAluno[][] = new double[n][3];
            double media[] = new double[n];

            for (int i = 0; i < nomeAluno.length; i++) {

                System.out.print("Aluno " + (i + 1) + " - Nome: ");
                nomeAluno[i] = sc.next();

                double soma = 0;

                for (int j = 0; j < pesoAluno[i].length; j++) {
                    System.out.print("Peso mês " + (j + 1) + ": ");
                    pesoAluno[i][j] = sc.nextDouble();

                    soma += pesoAluno[i][j];

                    media[i] = soma / pesoAluno[i].length;

                }
                System.out.println();
            }

            System.out.println();

            System.out.println("--- Resultados ---");

            for (int i = 0; i < pesoAluno.length; i++) {
                System.out.print("Média de " + nomeAluno[i] + ": ");
                System.out.printf("%.2f kg\n", media[i]);
            }
            System.out.println();

            double maiorPeso = Double.MIN_VALUE;
            int mesMaiorPeso = 0;

            double menorPeso = Double.MAX_VALUE;
            int mesMenorPeso = 0;

            for (int i = 0; i < pesoAluno.length; i++) {
                for (int j = 0; j < pesoAluno[i].length; j++) {

                    if (pesoAluno[i][j] > maiorPeso) {
                        maiorPeso = pesoAluno[i][j];
                        mesMaiorPeso = (j + 1);
                    }

                    if (pesoAluno[i][j] < menorPeso) {
                        menorPeso = pesoAluno[i][j];
                        mesMenorPeso = (j + 1);
                    }
                }

            }

            for (int i = 0; i < nomeAluno.length - 1; i++) {
                System.out.printf("Maior Peso: %.2f", maiorPeso);
                System.out.print(" kg (" + nomeAluno[i + 1] + ", mês " + mesMaiorPeso + ")\n");
            }

            for (int i = 0; i < nomeAluno.length - 1; i++) {
                System.out.printf("Menor Peso: %.2f", menorPeso);
                System.out.print(" kg (" + nomeAluno[i] + ", mês " + mesMenorPeso + ")\n");
            }

            System.out.print("\nAlunos que perderam peso: ");
            for (int i = 0; i < nomeAluno.length; i++) {
                if (pesoAluno[i][0] > pesoAluno[i][2]) {
                    System.out.print(nomeAluno[i] + " ");
                }
            }
        }

    }

}

package unit6.list9;

import java.util.Scanner;

public class Uni6Exe02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double notasAlunos[][] = new double[3][5];
        String nomeAluno[] = new String[3];

        lerMatriz(notasAlunos, sc, nomeAluno);
        mediaAluno(notasAlunos, nomeAluno);
        medianotasAlunos(notasAlunos);
    }

    public static void lerMatriz(double notasAlunos[][], Scanner sc, String nomeAluno[]) {

        for (int lin = 0; lin < notasAlunos.length; lin++) {
            System.out.print("Nome do aluno: ");
            nomeAluno[lin] = sc.nextLine();

            for (int col = 0; col < notasAlunos[lin].length; col++) {
                System.out.print(nomeAluno[lin] + " - Nota da notasAlunos " + (col + 1) + ": ");
                notasAlunos[lin][col] = sc.nextDouble();
            }
            sc.nextLine();
        }
    }

    public static void mediaAluno(double notasAlunos[][], String nomeAluno[]) {

        for (int lin = 0; lin < notasAlunos.length; lin++) {

            double soma = 0;

            for (int col = 0; col < notasAlunos[lin].length; col++) {

                soma += notasAlunos[lin][col];
            }

            double media = soma / notasAlunos[lin].length;

            System.out.println("Media de " + nomeAluno[lin] + ": " + media);
        }
    }

    public static void medianotasAlunos(double notasAlunos[][]) {

        for (int col = 0; col < notasAlunos[0].length; col++) {
            double soma = 0;
            for (int lin = 0; lin < notasAlunos.length; lin++) {

                soma += notasAlunos[lin][col];
            }

            double media = soma / notasAlunos.length;

            System.out.println("Media - notasAlunos " + (col + 1) + ": " + media);
        }
    }
}

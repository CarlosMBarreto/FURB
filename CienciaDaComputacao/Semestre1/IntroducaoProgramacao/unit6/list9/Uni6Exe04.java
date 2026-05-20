package unit6.list9;

import java.util.Scanner;

public class Uni6Exe04 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int departamentos;
        int funcionarios;

        do {
            System.out.print("Quantidade de departamentos: ");
            departamentos = sc.nextInt();

        } while (departamentos <= 0 || departamentos > 10);

        do {
            System.out.print("Quantidade de funcionarios: ");
            funcionarios = sc.nextInt();

        } while (funcionarios <= 0 || funcionarios > 20);

        double matriz[][] = new double[departamentos][funcionarios];

        lerMatriz(matriz, sc);

        maiorSalario(matriz);

        mediaDepartamentos(matriz);

        acimaMediaGeral(matriz);

        sc.close();
    }

    public static void lerMatriz(double matriz[][], Scanner sc) {

        for (int lin = 0; lin < matriz.length; lin++) {

            System.out.println("\nDepartamento " + (lin + 1));

            for (int col = 0; col < matriz[lin].length; col++) {

                System.out.print("Salario funcionario " + (col + 1) + ": ");

                matriz[lin][col] = sc.nextDouble();
            }
        }
    }

    public static void maiorSalario(double matriz[][]) {

        double maior = matriz[0][0];
        int departamento = 0;
        int funcionario = 0;

        for (int lin = 0; lin < matriz.length; lin++) {

            for (int col = 0; col < matriz[lin].length; col++) {

                if (matriz[lin][col] > maior) {

                    maior = matriz[lin][col];
                    departamento = lin;
                    funcionario = col;
                }
            }
        }

        System.out.println("\nMaior salario: " + maior);

        System.out.println("Departamento: "
                + (departamento + 1));

        System.out.println("Funcionario: "
                + (funcionario + 1));
    }

    public static void mediaDepartamentos(double matriz[][]) {

        for (int lin = 0; lin < matriz.length; lin++) {

            double soma = 0;

            for (int col = 0; col < matriz[lin].length; col++) {

                soma += matriz[lin][col];
            }

            double media = soma / matriz[lin].length;

            System.out.println("Media departamento "
                    + (lin + 1) + ": " + media);
        }
    }

    public static void acimaMediaGeral(double matriz[][]) {

        double soma = 0;
        int total = 0;

        for (int lin = 0; lin < matriz.length; lin++) {

            for (int col = 0; col < matriz[lin].length; col++) {

                soma += matriz[lin][col];
                total++;
            }
        }

        double mediaGeral = soma / total;

        int acima = 0;

        for (int lin = 0; lin < matriz.length; lin++) {

            for (int col = 0; col < matriz[lin].length; col++) {

                if (matriz[lin][col] > mediaGeral) {

                    acima++;
                }
            }
        }

        System.out.println("Media geral: " + mediaGeral);

        System.out.println("Funcionarios acima da media: "
                + acima);
    }
}
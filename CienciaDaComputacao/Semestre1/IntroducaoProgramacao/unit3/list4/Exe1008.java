package unit3.list4;

import java.io.IOException;
import java.util.Scanner;

public class Exe1008 {

    public static void main(String[] args) throws IOException {

        try (Scanner sc = new Scanner(System.in)) {

            int numeroFuncionario = sc.nextInt();

            int horasTrabalhadas = sc.nextInt();

            double valorHora = sc.nextDouble();

            double salario = horasTrabalhadas * valorHora;

            System.out.println("NUMBER = " + numeroFuncionario);
            System.out.printf("SALARY = U$ %.2f\n", salario);

        }
    }
}

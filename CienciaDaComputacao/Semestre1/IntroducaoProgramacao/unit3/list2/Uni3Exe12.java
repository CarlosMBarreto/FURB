package unit3.list2;

import java.util.Scanner;

public class Uni3Exe12 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            final double VALOR_HORA = 10.0;
            final double VALOR_DEPENDENTE = 60.0;
            final double INSS = 0.085;
            final double IMPOSTO_RENDA = 0.05;

            System.out.print("Informe seu nome: ");
            String nome = sc.nextLine();

            System.out.print("Quantidade de horas trabalhadas no mês: ");
            double horasTrabalhadas = sc.nextDouble();

            System.out.print("Número de dependentes: ");
            int numDependentes = sc.nextInt();

            double salarioTrabalho = horasTrabalhadas * VALOR_HORA;
            double salarioFamilia = numDependentes * VALOR_DEPENDENTE;

            double descInss = salarioTrabalho * INSS;
            double descImpostoRenda = salarioTrabalho * IMPOSTO_RENDA;

            double salarioBruto = salarioTrabalho + salarioFamilia;
            double salarioLiquido = salarioTrabalho + salarioFamilia- descInss - descImpostoRenda;

            System.out.println("O funcionário " + nome + " possui um salário bruto de R$" + salarioBruto + " e um salário líquido de R$" + salarioLiquido);

        }
    }
}

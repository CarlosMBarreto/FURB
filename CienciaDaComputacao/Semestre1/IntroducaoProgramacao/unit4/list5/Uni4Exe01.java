package unit4.list5;

import java.util.Scanner;

public class Uni4Exe01 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Horas trabalhadas no mês: ");
            double horasMes = sc.nextDouble();

            System.out.print("Valor da hora: ");
            double valorHora = sc.nextDouble();

            double salarioTotal = horasMes * valorHora;

            if (horasMes > 160) {
                double salarioExtra = (horasMes - 160) * (valorHora * 1.5);
                salarioTotal = salarioTotal + salarioExtra;
            }
            System.out.println("O salário total é: " + salarioTotal);
        }
    }
}

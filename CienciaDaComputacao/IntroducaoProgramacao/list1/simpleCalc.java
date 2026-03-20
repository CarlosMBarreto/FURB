package list1;

import java.util.Scanner;

public class simpleCalc {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            double[] vetNum = new double[2];

            double soma = 0;
            double subtracao = 0;
            double multiplicacao = 1;
            double divisao = 1;

            for (int i = 0; i < vetNum.length; i++) {
                System.out.print("Digite o número " + (i + 1) + ": ");
                vetNum[i] = sc.nextDouble();

                soma += vetNum[i];
                subtracao = vetNum[0] - vetNum[1];
                multiplicacao *= vetNum[i];
                divisao = vetNum[0] / vetNum[1];
            }

            System.out.println("Soma: " + soma);
            System.out.println("Subtração: " + subtracao);
            System.out.println("Multiplicação: " + multiplicacao);

            if (vetNum[0] == 0 || vetNum[1] == 0) {
                System.out.println("Divisão: impossível (divisão por zero)");
            } else {
                System.out.println("Divisão: " + divisao);
            }

        }
    }
}

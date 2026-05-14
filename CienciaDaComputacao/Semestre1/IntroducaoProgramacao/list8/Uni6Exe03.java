package list8;

import java.util.Scanner;

public class Uni6Exe03 {

    public static void main(String[] args) {

        double[] valor = new double[12];

        lerValores(valor);
        ajustarValores(valor);
        escreverValores(valor);
    }

    public static void lerValores(double[] valor) {
        try (Scanner sc = new Scanner(System.in)) {
            for (int i = 0; i < valor.length; i++) {
                System.out.print("Valor " + (i + 1) + ": ");
                valor[i] = sc.nextDouble();
            }
        }
    }

    public static void ajustarValores(double[] valor) {
        for (int i = 0; i < valor.length; i++) {
            if (i % 2 == 0) {
                valor[i] = valor[i] + (valor[i] * 0.02);
            } else {
                valor[i] = valor[i] + (valor[i] * 0.05);
            }
        }
    }

    public static void escreverValores(double[] valor) {
        System.out.print("Valores ajustados: ");
        for (int i = 0; i < valor.length; i++) {
            System.out.print("[" + valor[i] + "] ");
        }
    }
}
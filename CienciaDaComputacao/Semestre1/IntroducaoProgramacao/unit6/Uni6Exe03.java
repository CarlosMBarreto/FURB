package unit6;

import java.util.Scanner;

public class Uni6Exe03 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            double[] valor = new double[2];
            String valores = "";

            for (int i = 0; i < valor.length; i++) {
                valor[i] = sc.nextDouble();
            }
            for (int i = 0; i < valor.length; i++) {
                if (valor[i] % 2 == 0) {
                    valor[i] = valor[i] + (valor[i] * 0.02);
                    valores += valor[i] + " ";
                } else {
                    valor[i] = valor[i] + (valor[i] * 0.05);
                    valores += valor[i] + " ";
                }
            }
            for (int i = 0; i < valor.length; i++) {
                System.out.println(valor[i]);
            }
        }
    }
}

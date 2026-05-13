package unit6;

import java.util.Scanner;

public class Uni6Exe02 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            double[] valor = new double[12];
            double media = 0;
            String acima = "";

            for (int i = 0; i < valor.length; i++) {
                valor[i] = sc.nextDouble();
            }
            for (int i = 0; i < valor.length; i++) {
                media += valor[i] / valor.length;
            }
            for (int i = 0; i < valor.length; i++) {
                if(valor[i] > media){
                    System.out.println(valor[i]);
                    acima += valor[i] + " ";
                }
            }
            System.out.println("Média: " + media);
            System.out.println("--- Valores acima da média ---");
            System.out.println(acima);
        }
    }
}

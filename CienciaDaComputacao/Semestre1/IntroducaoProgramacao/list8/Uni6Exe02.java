package list8;

import java.util.Scanner;

public class Uni6Exe02 {
    public static void main(String[] args) {

        double[] valor = new double[4];

        lerValores(valor);

        double media = media(valor);

        System.out.println("Média: " + media);

        System.out.print("Valores acima da média:");
        acimaMedia(valor, media);

    }

    public static void lerValores(double[] valor) {
        try (Scanner sc = new Scanner(System.in)) {

            for (int i = 0; i < valor.length; i++) {
                System.out.print("Valor " + (i + 1) + ": ");
                valor[i] = sc.nextDouble();
            }
        }
    }

    public static double media(double[] valor) {

        double soma = 0;

        for (int i = 0; i < valor.length; i++) {
            soma += valor[i];
        }

        return soma / valor.length;
    }

    public static void acimaMedia(double[] valor, double media){
        for (int i = 0; i < valor.length; i++) {
                if(valor[i] > media){
                    System.out.print(valor[i] + "  ");
                }
            }
    }
}

package unit5.list7;

import java.util.Scanner;

public class Uni5Exe06 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            double mediaAltura = 0;
            double alturaTotal = 0;

            for(int p = 1;p <= 20; p++){
                System.out.println("Altura da pessoa " + p + ":" );
                double altura = sc.nextDouble();
                alturaTotal += altura;
                mediaAltura = alturaTotal / p;
            }
            System.out.println("A média das alturas é: " + mediaAltura);
        }
    }
}

package list7;

import java.util.Scanner;

public class Uni5Exe07 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            int n = sc.nextInt();
            double maior = Double.MIN_VALUE;
            double menor = Double.MAX_VALUE;

            for(int i = 1;i <= n; i++){
                System.out.print("Informe o " + i + "º número: ");
                double numero = sc.nextDouble();
                
                if(numero > maior){
                    maior = numero;
                }
                if(numero < menor){
                    menor = numero;
                }
            }
            System.out.println("Maior número: " + maior);
            System.out.println("Menor número: " + menor);
        }
    }
}

package list5;

import java.util.Scanner;

public class Uni4Exe21 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Altura: ");
            double altura = sc.nextDouble();

            System.out.print("Massa: ");
            double massa = sc.nextDouble();

            double imc = massa / Math.pow(altura, 2);

            String classificacao = "";

            if (imc < 18.5) {
                classificacao = "Magreza";

            } else if (imc >= 18.5 && imc < 24.9) {
                classificacao = "Saudável";

            } else if (imc >= 25.0 && imc < 29.9) {
                classificacao = "Sobrepeso";

            } else if (imc >= 30.0 && imc < 34.9) {
                classificacao = "Obesidade Grau I";

            } else if (imc >= 35.0 && imc < 39.9) {
                classificacao = "Obesidade Grau II (severa)";

            } else if (imc >= 40.0){
                classificacao = "Obesidade Grau III (mórbida)";
            }

            System.out.println(classificacao);
        }
    }
}

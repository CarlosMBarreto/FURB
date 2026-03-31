package list5;

import java.util.Scanner;

public class Uni4Exe24 {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Valor 1:");
            double n1 = sc.nextDouble();
            System.out.print("Valor 2:");
            double n2 = sc.nextDouble();
            System.out.print("Valor 3:");
            double n3 = sc.nextDouble();

            double maior = 0;
            double medio = 0;
            double menor = 0;

            if (n1 > n2 && n1 > n3 && n2 > n3) {
                maior = n1;
                medio = n2;
                menor = n3;
            } else if (n2 > n1 && n2 > n3 && n1 > n3) {
                maior = n2;
                medio = n1;
                menor = n3;
            } else if (n3 > n1 && n3 > n2 && n2 > n1) {
                maior = n3;
                medio = n2;
                menor = n1;
            } else if (n1 > n2 && n1 > n3 && n3 > n2) {
                maior = n1;
                medio = n3;
                menor = n2;
            }

            System.out.print("Opção:");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println(menor + " " + medio + " " + maior);
                    break;

                case 2:
                    System.out.println(maior + " " + medio + " " + menor);
                    break;
                case 3:
                    System.out.println(medio + " " + maior + " " + menor);
                    break;
            }
        }
    }
}

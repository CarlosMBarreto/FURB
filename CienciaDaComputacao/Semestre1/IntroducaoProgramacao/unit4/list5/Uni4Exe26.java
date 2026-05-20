package unit4.list5;

import java.util.Scanner;

public class Uni4Exe26 {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Opção:");
            char opcao = sc.next().charAt(0);

            switch (opcao) {
                case 'T':
                    System.out.print("Base:");
                    double b = sc.nextDouble();
                    System.out.print("Altura:");
                    double h = sc.nextDouble();

                    double areaTriangulo = (b * h) / 2;

                    System.out.println(areaTriangulo);
                    break;
                case 'Q':
                    System.out.print("Lado:");
                    double l = sc.nextDouble();

                    double areaQuadrado = Math.pow(l, 2);

                    System.out.println(areaQuadrado);
                    break;
                case 'R':
                    System.out.print("Base:");
                    double b2 = sc.nextDouble();
                    System.out.print("Altura:");
                    double h2 = sc.nextDouble();

                    double areaRetangulo = b2 * h2;

                    System.out.println(areaRetangulo);
                    break;
                case 'C':
                    System.out.print("Raio:");
                    double r = sc.nextDouble();
                    
                    double areaCirculo = Math.PI * Math.pow(r, 2);

                    System.out.printf("%.2f",areaCirculo);
                    break;
            }
        }
    }
}

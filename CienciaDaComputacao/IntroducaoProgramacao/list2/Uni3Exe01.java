package list2;

import java.util.Scanner;

public class Uni3Exe01 {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Informe a largura do terreno: ");
            double largura = sc.nextDouble();

            System.out.print("Informe a comprimento do terreno: ");
            double comprimento = sc.nextDouble();

            double areaTerreno = largura * comprimento;

            System.out.println("Área do terreno: " + areaTerreno);
        }
    }
}
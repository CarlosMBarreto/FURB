package unit3.list2;

import java.util.Scanner;

public class Uni3Exe07 {

    public static void main(String[] args) {
        
        try(Scanner sc = new Scanner(System.in)){

            final double lata = 0.350;
            final double garrafa600 = 0.600;
            final double garrafa2L = 2;

            System.out.print("Quantidade de 350ml: ");
            double qtdlata = sc.nextDouble();

            System.out.print("Quantidade de 600ml: ");
            double qtdgarrafa600 = sc.nextDouble();

            System.out.print("Quantidade de 2L: ");
            double qtdgarrafa2L = sc.nextDouble();

            double totalLitros = (qtdlata * lata) + (qtdgarrafa600 * garrafa600) + (qtdgarrafa2L * garrafa2L);

            System.out.println("O cliente comprou ao total " + totalLitros + " litros.");


        }
    }
}

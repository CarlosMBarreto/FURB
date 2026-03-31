package list2;

import java.util.Scanner;

public class Uni3Exe05 {

    public static void main(String[] args) {
        
        try(Scanner sc = new Scanner(System.in)){

            final double anelChip = 4;
            final double anelAlimento = 3.5;

            final double anelAnimal = (anelAlimento * 2) + anelChip;

            System.out.print("Informe o número total de frangos: ");
            double numeroFrangos = sc.nextDouble();

            double totalGasto = anelAnimal * numeroFrangos;

            System.out.println("O total para marcar " + numeroFrangos + " frangos é R$" + totalGasto);


        }
    }
}

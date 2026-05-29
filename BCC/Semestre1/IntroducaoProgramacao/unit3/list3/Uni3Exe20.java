package unit3.list3;

import java.util.Scanner;

public class Uni3Exe20 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            final double precoGasolina = 5.75;
            final double precoEtanol = 4.29;

            System.out.print("Gasolina: ");
            double litrosGasolina = sc.nextDouble();

            System.out.print("Etanol: ");
            double litrosEtanol = sc.nextDouble();

            double valorGasolina = precoGasolina * litrosGasolina;
            double valorEtanol = precoEtanol * litrosEtanol;

            double valorTotal = valorGasolina + valorEtanol;

            System.out.println("Valor gasolina: R$" + valorGasolina);
            System.out.println("Valor etanol: R$" + valorEtanol);
            System.out.println("Valor total: R$" + valorTotal);
            
        }
    }
}

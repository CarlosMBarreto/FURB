package list2;

import java.util.Scanner;

public class Uni3Exe03 {

    public static void main(String[] args) {
        
        try(Scanner sc = new Scanner(System.in)){

            System.out.print("Informe o preço da gasolina: ");
            double precoGasolina = sc.nextDouble();

            System.out.print("Informe o valor do pagamento: ");
            double valorPagamento = sc.nextDouble();

            double litrosTanque = valorPagamento / precoGasolina;

            System.out.println("O motorista conseguiu colocar: " + litrosTanque + " litros.");

        }
    }
}

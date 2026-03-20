package list2;

import java.util.Scanner;

public class Uni3Exe06 {
    
    public static void main(String[] args) {
        
        try(Scanner sc = new Scanner(System.in)){

            final double precoQuiloRefeicao = 25;

            System.out.println("Informe o peso do prato(kg): ");
            double pesoPrato = sc.nextDouble();

            pesoPrato -= 0.750;

            double precoPrato = precoQuiloRefeicao * pesoPrato;

            System.out.println("O valor do prato do cliente é R$" + precoPrato);
        }
    }
}

package list5;

import java.util.Scanner;

public class Uni4Exe07 {

    public static void main(String[] args) {
        
        try(Scanner sc = new Scanner(System.in)){

            System.out.print("Peso da carta:");
            double pesoGramas = sc.nextDouble();

            double valorPagar;

            if(pesoGramas > 50){
                double pesoExcedido = pesoGramas - 50;
                double qtdAdicional = (pesoExcedido / 20) + 1;
                valorPagar = 0.45 + 0.45 * qtdAdicional;
            } else {
                valorPagar = 0.45;
            }

            System.out.printf("Custo do selo: R$%.2f", valorPagar);
        }
    }
}

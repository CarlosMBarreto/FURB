package list2;

import java.util.Scanner;

public class Uni3Exe08 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            final double cotacaoDolar = 5.65;

            System.out.print("Valor em dólares recebido pelo cliente: ");
            double valRecebido = sc.nextDouble();

            System.out.println("Cotação do dólar hoje: " + cotacaoDolar);

            double valConversao = valRecebido * cotacaoDolar;

            System.out.println("O atendente deve devolver R$" + valConversao + " para o cliente.");
        }
    }
}

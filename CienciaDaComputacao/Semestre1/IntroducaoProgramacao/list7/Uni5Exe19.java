package list7;

import java.util.Scanner;

public class Uni5Exe19 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            double valor, total = 0;

            while (true) {
                System.out.print("Valor: ");
                valor = sc.nextDouble();
                if (valor == 0) break;

                double pagar = (valor > 500) ? valor * 0.8 : valor * 0.85;
                total += pagar;

                System.out.println("Pagar: " + pagar);
            }

            System.out.println("Total: " + total);
        }
    }
}
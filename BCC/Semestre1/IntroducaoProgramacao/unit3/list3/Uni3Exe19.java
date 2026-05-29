package unit3.list3;

import java.util.Scanner;

public class Uni3Exe19 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Salário: ");
            double salario = sc.nextDouble();

            System.out.print("Meses trabalhados: ");
            int meses = sc.nextInt();

            double decimoTerceiro = salario / 12 * meses;

            System.out.println("O valor do 13º salário é R$" + decimoTerceiro);
        }
    }
}

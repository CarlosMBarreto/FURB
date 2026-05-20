package unit4.list5;

import java.util.Scanner;

public class Uni4Exe15 {

    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)){

            System.out.print("Meses desde que o funcionário foi admitido:");
            int meses = sc.nextInt();

            if(meses > 0 && meses < 13){
                System.out.println("O funcionário irá receber 5% de reajuste");
            } else if (meses >= 13 && meses <= 48){
                System.out.println("O funcionário irá receber 7% de reajuste");
            } else if (meses > 48){
                System.out.println("Reajuste não informado");
            }
        }
    }
}

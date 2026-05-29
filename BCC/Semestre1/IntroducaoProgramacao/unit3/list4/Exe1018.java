package unit3.list4;

import java.util.Scanner;

public class Exe1018 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            int valor = sc.nextInt();

            int val = valor;

            int cedula100 = valor / 100;
            valor = valor % 100;

            int cedula50 = valor / 50;
            valor = valor % 50;

            int cedula20 = valor / 20;
            valor = valor % 20;

            int cedula10 = valor / 10;
            valor = valor % 10;

            int cedula5 = valor / 5;
            valor = valor % 5;

            int cedula2 = valor / 2;
            valor = valor % 2;

            int cedula1 = valor % 10;

            System.out.println(val);
            System.out.println(cedula100 + " nota(s) de R$ 100,00");
            System.out.println(cedula50 + " nota(s) de R$ 50,00");
            System.out.println(cedula20 + " nota(s) de R$ 20,00");
            System.out.println(cedula10 + " nota(s) de R$ 10,00");
            System.out.println(cedula5 + " nota(s) de R$ 5,00");
            System.out.println(cedula2 + " nota(s) de R$ 2,00");
            System.out.println(cedula1 + " nota(s) de R$ 1,00");
        }
    }
}

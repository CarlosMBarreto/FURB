package BCC.Semestre2.POO.Unit1.list1.Ex4;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            Pessoa usuario[] = new Pessoa[3];

            for (int i = 0; i < usuario.length; i++) {
                usuario[i] = new Pessoa();
                System.out.println("--- Pessoa " + (i + 1) + "---");
                System.out.print("Nome: ");
                usuario[i].nome = sc.next();

                System.out.print("Altura: ");
                usuario[i].altura = sc.nextDouble();

                System.out.print("Peso: ");
                usuario[i].peso = sc.nextDouble();

                sc.nextLine();
            }

            for (int i = (usuario.length - 1); i >= 0; i--) {
                System.out.println("---Pessoa " + (usuario.length - i) + "---");
                System.out.print(usuario[i]);
                System.out.println("\n---------------");
            }
        }
    }
}

package BCC.Semestre2.POO.Unit1.list2.Ex1;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            Pessoa usuario[] = new Pessoa[3];

            for (int i = 0; i < usuario.length; i++) {
                usuario[i] = new Pessoa();
                System.out.println("--- Pessoa " + (i + 1) + "---");
                System.out.print("Nome: ");
                usuario[i].setNome(sc.next());

                System.out.print("Altura: ");
                usuario[i].setAltura(sc.nextDouble());

                System.out.print("Peso: ");
                usuario[i].setPeso(sc.nextDouble());

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

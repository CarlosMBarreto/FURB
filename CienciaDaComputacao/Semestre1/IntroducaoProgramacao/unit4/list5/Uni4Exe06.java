package unit4.list5;

import java.util.Scanner;

public class Uni4Exe06 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Informe seu gênero:");
            char letra = sc.next().charAt(0);

            letra = Character.toUpperCase(letra);

            if (letra == 'M') {
                System.out.println("Masculino");
            } else if (letra == 'F') {
                System.out.println("Feminino");
            } else if (letra == 'I') {
                System.out.println("Não informado");
            } else {
                System.out.println("Entrada Incorreta");
            }
        }
    }
}

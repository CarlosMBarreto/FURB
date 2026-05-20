package unit5;

import java.util.Scanner;

public class ExemploUnit5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Exemplo FOR:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Número: " + i);
        }

        System.out.println("\nExemplo WHILE:");
        int contador = 1;

        while (contador <= 5) {
            System.out.println("Contador: " + contador);
            contador++;
        }

        System.out.println("\nExemplo DO WHILE:");

        int numero;

        do {
            System.out.print("Digite um número maior que 0: ");
            numero = sc.nextInt();

        } while (numero <= 0);

        System.out.println("Número válido digitado: " + numero);

        sc.close();
    }
}

package unit6.list8;

import java.util.Scanner;

public class Uni6Exe06 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Informe N: ");
        int n = sc.nextInt();

        double vet[] = new double[n];

        lerVetores(vet, sc);
        verificacao(vet, sc);

    }

    public static void lerVetores(double[] vet, Scanner sc) {
        for (int i = 0; i < vet.length; i++) {
            System.out.print("Valor " + (i + 1) + ": ");
            vet[i] = sc.nextDouble();
        }
    }

    public static void verificacao(double[] vet, Scanner sc) {

        double numero = 0;

        boolean verificacao = false;

        System.out.print("Informe o número para verificação: ");
        numero = sc.nextDouble();

        for (int i = 0; i < vet.length; i++) {
            if(vet[i] == numero){
                verificacao = true;
            }
        }

        System.out.println("Valor encontrado(true/false): " + verificacao);
    }
}

package list8;

import java.util.Scanner;

public class Uni6Exe09 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int generoClientes[] = new int[30];
        int notaClientes[] = new int[30];
        int idadeClientes[] = new int[30];

        lerValores(generoClientes, notaClientes, idadeClientes, sc);
        notaMedia(generoClientes, notaClientes, idadeClientes, sc);
        notaMediaHomem(generoClientes, notaClientes, idadeClientes, sc);
        notaMulherJovem(generoClientes, notaClientes, idadeClientes, sc);
        mulheres50(generoClientes, notaClientes, idadeClientes, sc);
    }

    public static void lerValores(int[] generoClientes, int[] notaClientes, int[] idadeClientes, Scanner sc) {

        for (int i = 0; i < generoClientes.length; i++) {
            System.out.print("---Gênero---\n(Feminino = 1)  (Masculino = 2)\nResposta: ");
            generoClientes[i] = sc.nextInt();

            System.out.print("Nota: ");
            notaClientes[i] = sc.nextInt();

            System.out.print("Idade: ");
            idadeClientes[i] = sc.nextInt();
        }
    }

    public static void notaMedia(int[] generoClientes, int[] notaClientes, int[] idadeClientes, Scanner sc) {

        int soma = 0;
        double media = 0;

        for (int i = 0; i < notaClientes.length; i++) {
            soma += notaClientes[i];
        }
        media = (double) soma / notaClientes.length;

        System.out.println("Média Geral: " + media);
    }

    public static void notaMediaHomem(int[] generoClientes, int[] notaClientes, int[] idadeClientes, Scanner sc) {

        int soma = 0;
        double media = 0;
        int homem = 0;

        for (int i = 0; i < notaClientes.length; i++) {
            if (generoClientes[i] == 2) {
                soma += notaClientes[i];
                homem++;
            }
        }
        media = (double) soma / homem;

        System.out.println("Nota média dos homens: " + media);
    }

    public static void notaMulherJovem(int[] generoClientes, int[] notaClientes, int[] idadeClientes, Scanner sc) {

        int maisJovem = Integer.MAX_VALUE;
        int nota = 0;

        for (int i = 0; i < idadeClientes.length; i++) {
            if (idadeClientes[i] < maisJovem && generoClientes[i] == 1) {
                maisJovem = idadeClientes[i];
                nota = notaClientes[i];
            }
        }
        System.out.println("Nota da mulher mais jovem: " + nota);
    }

    public static void mulheres50(int[] generoClientes, int[] notaClientes, int[] idadeClientes, Scanner sc) {

        int soma = 0;
        double media = 0;
        int qtdMulheres = 0;

        for (int i = 0; i < notaClientes.length; i++) {
            soma += notaClientes[i];
        }
        media = (double) soma / notaClientes.length;

        for (int i = 0; i < generoClientes.length; i++) {
            if (idadeClientes[i] > 50 && generoClientes[i] == 1 && notaClientes[i] > media) {
                qtdMulheres++;
            }
        }
        System.out.println("Quantidade de mulheres de 50+ que deram a nota acima da média: " + qtdMulheres);
    }
}

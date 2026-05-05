package list7;

import java.util.Scanner;

public class Uni5Exe17 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            int inscricao, maiorIns = 0, menorIns = 0, cont = 0;
            double altura, maior = Double.MIN_VALUE, menor = Double.MAX_VALUE, soma = 0;

            while (true) {
                System.out.print("Nº inscrição: ");
                inscricao = sc.nextInt();
                if (inscricao == 0) break;

                System.out.print("Altura: ");
                altura = sc.nextDouble();

                if (altura > maior) {
                    maior = altura;
                    maiorIns = inscricao;
                }

                if (altura < menor) {
                    menor = altura;
                    menorIns = inscricao;
                }

                soma += altura;
                cont++;
            }

            System.out.println("Mais baixo: " + menor + " (" + menorIns + ")");
            System.out.println("Mais alto: " + maior + " (" + maiorIns + ")");
            System.out.println("Média: " + (soma / cont));
        }
    }
}
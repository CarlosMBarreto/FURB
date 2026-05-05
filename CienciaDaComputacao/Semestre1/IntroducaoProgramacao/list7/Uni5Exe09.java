package list7;

import java.util.Scanner;

public class Uni5Exe09 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            int n = sc.nextInt();
            sc.nextLine();

            String nomes18 = "";
            int acima20 = 0;

            for (int i = 1; i <= n; i++) {
                System.out.print("Nome: ");
                String nome = sc.nextLine();

                System.out.print("Idade: ");
                int idade = sc.nextInt();
                sc.nextLine();

                if (idade == 18) {
                    if (!nomes18.isEmpty()) {
                        nomes18 += " e ";
                    }
                    nomes18 += nome;
                }

                if (idade > 20) {
                    acima20++;
                }
            }

            System.out.println("Nomes dos alunos que tem 18 anos: " + nomes18);
            System.out.println("Quantidade de alunos que tem idade acima de 20 anos: " + acima20);
        }
    }
}

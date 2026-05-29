
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Aluno aluno[] = new Aluno[5];

        System.out.println("=== CADASTRO ===");
        for (int i = 0; i < aluno.length; i++) {

            System.out.print("Aluno: ");
            String nome = sc.nextLine();

            System.out.print("Nota de " + nome + ": ");
            double nota = sc.nextDouble();

            aluno[i] = new Aluno(nome, nota);

            sc.nextLine();
        }

        System.out.println("\n\n=== RESULTADO ===");
        for (int i = 0; i < aluno.length; i++) {
            System.out.println(aluno[i].nome + " - " + aluno[i].nota + " - " + aluno[i].situacao());
        }
    }
}

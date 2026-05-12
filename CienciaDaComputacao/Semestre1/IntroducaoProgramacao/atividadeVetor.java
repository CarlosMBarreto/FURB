package CienciaDaComputacao.Semestre1.IntroducaoProgramacao;

import java.util.Scanner;

public class atividadeVetor {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            String nomeAlunos[] = new String[3];
            double notaAlunos[] = new double[3];
            String aprovados = "";
            String reprovados = "";
            double maiorNota = Double.MIN_VALUE;
            double menorNota = Double.MAX_VALUE;

            for (int i = 0; i < nomeAlunos.length; i++) {
                double mediaAluno = 0;
                System.out.print("Informe o nome do " + (i + 1) + "° aluno: ");
                nomeAlunos[i] = sc.nextLine();
                for (int n = 0; n < notaAlunos.length; n++) {

                    do {
                        System.out.print("Nota " + (n + 1) + ": ");
                        notaAlunos[n] = sc.nextDouble();
                        if (notaAlunos[n] < 0 || notaAlunos[n] > 10) {
                            System.out.println("Valor não aceito.");
                        }
                    } while (notaAlunos[n] < 0 || notaAlunos[n] > 10);

                    mediaAluno += notaAlunos[n];

                    if(notaAlunos[n] > maiorNota){
                        maiorNota = notaAlunos[n];
                    }
                    if(notaAlunos[n] < menorNota){
                        menorNota = notaAlunos[n];
                    }
                }

                mediaAluno = mediaAluno / 3;

                if (mediaAluno >= 7) {
                    aprovados += nomeAlunos[i] + " -> Média: " + mediaAluno + "\n";
                } else {
                    reprovados += nomeAlunos[i] + " -> Média: " + mediaAluno + "\n";
                }
                sc.nextLine();
            }
            System.out.println("---Aprovados---\n" + aprovados);
            System.out.println("---Reprovados---\n" + reprovados);
            System.out.println("Maior nota: " + maiorNota);
            System.out.println("Menor nota: " + menorNota);
            System.out.println("---Ordem de nota---\n" + reprovados);
        }
    }
}

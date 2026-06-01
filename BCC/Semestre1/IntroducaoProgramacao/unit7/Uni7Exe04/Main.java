
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Sala vetSala[] = new Sala[5];

        for (int i = 0; i < vetSala.length; i++) {
            vetSala[i] = new Sala(i + 1, new boolean[4][6]);
        }

        Scanner sc = new Scanner(System.in);

        int opcao = 0;

        int sala = 0;
        int coluna = 0;

        do {
            System.out.println("1 - Escolher sala e ver mapa");
            System.out.println("2 - Reservar assento");
            System.out.println("3 - Cancelar reserva");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Sala (1-5): ");
                    sala = sc.nextInt();

                    if (sala < 1 || sala > 5) {
                        System.out.println("Sala invalida.(" + sala + ")");
                    } else {
                        int i = sala - 1;
                        System.out.println("\n\n=== SALA " + sala + " ===");
                        vetSala[i].exibirMapa();
                        System.out.print("Ocupacao: ");
                        vetSala[i].percentualOcupacao();
                    }
                    break;

                case 2:
                    System.out.print("Sala (1-5): ");
                    sala = sc.nextInt();

                    if (sala < 1 || sala > 5) {
                        System.out.println("Sala invalida.(" + sala + ")");
                    } else {
                        System.out.print("Fileira (A-D): ");
                        String fileira = sc.next();

                        fileira = fileira.toUpperCase();

                        if (!fileira.equals("A") && !fileira.equals("B") && !fileira.equals("C")
                                && !fileira.equals("D")) {
                            System.out.println("Fileira invalida.(" + fileira + ")");

                        } else {
                            int fileiraIndice = 0;

                            switch (fileira) {
                                case "A":
                                    fileiraIndice = 0;
                                    break;
                                case "B":
                                    fileiraIndice = 1;
                                    break;
                                case "C":
                                    fileiraIndice = 2;
                                    break;
                                case "D":
                                    fileiraIndice = 3;
                                    break;
                            }
                            System.out.print("Coluna (1-6): ");
                            coluna = sc.nextInt();

                            if (coluna < 1 || coluna > 6) {
                                System.out.println("Coluna invalida.(" + coluna + ")");
                            } else {
                                vetSala[sala - 1].reservar(fileiraIndice, coluna - 1);
                            }
                        }
                    }
                    break;

                case 3:
                    System.out.print("Sala (1-5): ");
                    sala = sc.nextInt();

                    if (sala < 1 || sala > 5) {
                        System.out.println("Sala invalida.(" + sala + ")");
                    } else {
                        System.out.print("Fileira (A-D): ");
                        String fileira = sc.next();

                        fileira = fileira.toUpperCase();

                        if (!fileira.equals("A") && !fileira.equals("B") && !fileira.equals("C")
                                && !fileira.equals("D")) {
                            System.out.println("Fileira invalida.(" + fileira + ")");

                        } else {
                            int fileiraIndice = 0;

                            switch (fileira) {
                                case "A":
                                    fileiraIndice = 0;
                                    break;
                                case "B":
                                    fileiraIndice = 1;
                                    break;
                                case "C":
                                    fileiraIndice = 2;
                                    break;
                                case "D":
                                    fileiraIndice = 3;
                                    break;
                            }
                            System.out.print("Coluna (1-6): ");
                            coluna = sc.nextInt();

                            if (coluna < 1 || coluna > 6) {
                                System.out.println("Coluna invalida.(" + coluna + ")");
                            } else {
                                vetSala[sala - 1].cancelar(fileiraIndice, coluna - 1);
                            }
                        }
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }

        } while (opcao != 0);
    }
}

package ProjetoFinal;

import java.util.Random;
import java.util.Scanner;

public class Sala {
    private boolean assentos[][] = new boolean[10][10];
    private double bilheteria = 0;
    private final int assentosOcupados = 15;

    public Sala() {
    }

    public void randomizarAssentos() {
        Random rand = new Random();

        int preenchidos = 0;

        while (preenchidos < assentosOcupados) {
            int i = rand.nextInt(assentos.length);
            int j = rand.nextInt(assentos[0].length);

            if (!assentos[i][j]) {
                assentos[i][j] = true;
                preenchidos++;
            }
        }
    }

    public void exibirSala() {

        System.out.println("\t ------------ TELA ------------  ");
        System.out.print("\t");
        for (int i = 0; i < assentos.length; i++) {
            System.out.print("  " + i);
        }
        System.out.println();

        for (int i = 0; i < assentos.length; i++) {
            System.out.print("\t" + i);
            for (int j = 0; j < assentos[i].length; j++) {
                if (assentos[i][j]) {
                    System.out.print("[#]");
                } else {
                    System.out.print("[-]");
                }
            }
            System.out.println();
        }
    }

    public boolean posicaoValida(int fileira, int coluna) {
        if ((fileira < 0 || fileira >= assentos.length) || (coluna < 0 || coluna >= assentos[0].length)) {
            System.out.println("Fora do limite.");
            return false;
        }
        if (assentos[fileira][coluna]) {
            System.out.println("Poltrona ocupada.");
            return false;
        }
        return true;
    }

    public void reservar(int fileira, int coluna, int tipo, Scanner sc) {

        double preco = calcularPreco(fileira, tipo);

        String setor = "";

        char r;

        if (fileira >= 0 && fileira < 2) {
            setor = "Poltrona(frente)";
        } else if (fileira >= 2 && fileira < 8) {
            setor = "Poltrona(meio)";
        } else if (fileira >= 8 && fileira <= 9) {
            setor = "Poltrona(VIP)";
        }

        System.out.println(setor);
        System.out.printf("Valor: R$ %.2f\n", preco);
        System.out.print("Confirmar? (S/N): ");
        r = sc.next().toUpperCase().charAt(0);

        if (r == 'S') {
            assentos[fileira][coluna] = true;
            System.out.println("Compra realizada!");
            bilheteria += preco;
        } else {
            System.out.println("Reserva cancelada.");
        }
    }

    public double percentualOcupacao() {
        int ocupados = 0;

        for (int i = 0; i < assentos.length; i++) {
            for (int j = 0; j < assentos[i].length; j++) {
                if (assentos[i][j]) {
                    ocupados++;
                }
            }
        }

        double porcentagem = (ocupados / (double) (assentos.length * assentos[0].length)) * 100;

        return porcentagem;
    }

    public int ingressosVendidos() {

        int ingressos = 0;

        for (int i = 0; i < assentos.length; i++) {
            for (int j = 0; j < assentos[i].length; j++) {
                if (assentos[i][j]) {
                    ingressos++;
                }
            }
        }

        return ingressos - assentosOcupados;
    }

    public double getBilheteria() {
        return bilheteria;
    }

    public String classificacao(double porcentagem) {

        if (porcentagem >= 0 && porcentagem < 40) {
            return "Sala Vazia - precisa divulgar mais";
        } else if (porcentagem >= 40 && porcentagem < 70) {
            return "Sessão Mediana";
        } else if (porcentagem >= 70 && porcentagem < 90) {
            return "Casa Cheia";
        }
        return "Sessão Esgotada - Sucesso de bilheteria!";
    }

    public double calcularPreco(int fileira, int tipo) {
        double preco = 0;

        if (fileira >= 0 && fileira < 2) {
            preco = 15;
        } else if (fileira >= 2 && fileira < 8) {
            preco = 25;
        } else if (fileira >= 8 && fileira <= 9) {
            preco = 35;
        }

        if (tipo == 2) {
            preco /= 2;
        }

        return preco;
    }

    public void resumo() {
        double ocupacao = percentualOcupacao();

        System.out.println("\n\t===== RESUMO =====");
        System.out.println("Ingressos vendidos: " + ingressosVendidos());
        System.out.printf("Bilheteria: R$ %.2f\n", getBilheteria());
        System.out.printf("Ocupação: %.2f%%\n", ocupacao);
        System.out.println(classificacao(ocupacao) + "\n");
    }
}

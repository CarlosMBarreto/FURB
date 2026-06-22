package ProjetoFinal;

import java.util.Random;
import java.util.Scanner;

/**
 * Representa uma sala de cinema com uma matriz de assentos (poltronas).
 * <p>
 * A sala é modelada como uma matriz {@code assentos[fileira][coluna]} de
 * tamanho fixo 10x10, totalizando 100 poltronas. Na convenção usada neste
 * projeto, {@code fileira} é o eixo horizontal (cresce para a direita,
 * representando as colunas de poltronas vistas de frente para a tela) e
 * {@code coluna} é o eixo vertical (cresce para cima, representando as filas de
 * poltronas). Essa orientação é o inverso da convenção usual de impressão de
 * matrizes (linha = vertical, coluna = horizontal), então é importante ter isso
 * em mente ao interpretar {@link #exibirSala()} e ao ler/escrever os índices
 * {@code [i][j]} pelo código.
 * <p>
 * A classe é responsável por:
 * <ul>
 * <li>controlar o estado de ocupação dos assentos;</li>
 * <li>calcular o preço do ingresso de acordo com o setor e o tipo;</li>
 * <li>processar reservas/compras feitas pelo cliente;</li>
 * <li>gerar estatísticas de ocupação e bilheteria da sessão.</li>
 * </ul>
 */
public class Sala {

    /**
     * Matriz de assentos da sala (10x10). {@code true} = ocupado, {@code false}
     * = livre.
     */
    private boolean assentos[][] = new boolean[10][10];

    /**
     * Valor total já arrecadado com a venda de ingressos nesta sessão (em R$).
     */
    private double bilheteria = 0;

    /**
     * Quantidade de poltronas pré-ocupadas aleatoriamente por
     * {@link #randomizarAssentos()} antes da abertura do totem, simulando
     * vendas feitas por outros canais (ex.: site, bilheteria física). Usado
     * para excluir essas vendas da contagem de {@link #ingressosVendidos()}.
     */
    private final int assentosOcupados = 15;

    /**
     * Cria uma nova sala com todas as 100 poltronas inicialmente livres.
     */
    public Sala() {
    }

    /**
     * Sorteia aleatoriamente {@code assentosOcupados} (15) poltronas distintas
     * e as marca como ocupadas, simulando assentos já vendidos antes da
     * abertura do totem de autoatendimento.
     * <p>
     * O sorteio usa um laço de tentativas: gera coordenadas aleatórias e só
     * conta como "preenchido" se a poltrona sorteada ainda estiver livre,
     * evitando marcar a mesma poltrona duas vezes.
     */
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

    /**
     * Imprime no console o mapa visual da sala: uma linha de cabeçalho com os
     * índices de coluna, seguida de uma linha por fileira mostrando cada
     * poltrona como {@code [#]} (ocupada) ou {@code [-]} (livre).
     */
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

    /**
     * Verifica se uma posição (fileira, coluna) pode receber uma nova reserva.
     * <p>
     * A posição é considerada inválida em dois casos, cada um com sua própria
     * mensagem impressa no console:
     * <ol>
     * <li>fileira ou coluna fora dos limites da matriz (0 a 9) → "Fora do
     * limite.";</li>
     * <li>posição dentro dos limites, mas poltrona já ocupada → "Poltrona
     * ocupada.".</li>
     * </ol>
     *
     * @param fileira índice da fileira (eixo horizontal), de 0 a 9
     * @param coluna índice da coluna (eixo vertical), de 0 a 9
     * @return {@code true} se a posição existe e está livre; {@code false} caso
     * contrário
     */
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

    /**
     * Processa a compra/reserva de uma poltrona específica.
     * <p>
     * Fluxo: calcula o preço via {@link #calcularPreco(int, int)}, identifica o
     * nome do setor (frente/meio/VIP) para exibição, mostra o valor ao cliente
     * e pede confirmação (S/N) via {@link Scanner}. Se confirmado, marca a
     * poltrona como ocupada e soma o valor à {@link #bilheteria}. Caso
     * contrário, apenas informa que a reserva foi cancelada.
     * <p>
     * <b>Pré-condição:</b> este método não valida novamente se a posição está
     * dentro dos limites ou se já está ocupada — isso deve ser garantido antes
     * de chamá-lo, normalmente com {@link #posicaoValida(int, int)}.
     *
     * @param fileira índice da fileira (eixo horizontal), de 0 a 9
     * @param coluna índice da coluna (eixo vertical), de 0 a 9
     * @param tipo tipo de ingresso: {@code 1} = inteira, {@code 2} = meia (50%
     * de desconto)
     * @param sc {@link Scanner} usado para ler a confirmação do cliente (S/N)
     */
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

    /**
     * Calcula o percentual de poltronas ocupadas em relação ao total de
     * poltronas da sala (10x10 = 100), considerando tanto as ocupadas pelo
     * sorteio inicial quanto as vendidas pelo totem.
     *
     * @return percentual de ocupação da sala, de 0.0 a 100.0
     */
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

    /**
     * Calcula quantos ingressos foram efetivamente vendidos através do totem de
     * autoatendimento (via {@link #reservar}), excluindo as
     * {@link #assentosOcupados} poltronas pré-ocupadas por
     * {@link #randomizarAssentos()}.
     * <p>
     * Implementação: conta todas as poltronas ocupadas na matriz e subtrai o
     * total de poltronas pré-ocupadas no sorteio inicial.
     *
     * @return número de ingressos vendidos pelo totem
     */
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

    /**
     * @return valor total já arrecadado com a venda de ingressos nesta sessão
     * (em R$)
     */
    public double getBilheteria() {
        return bilheteria;
    }

    /**
     * Classifica a sessão de acordo com a faixa em que o percentual de ocupação
     * informado se encontra:
     *
     * 0% a 39,9...% → "Sala Vazia - precisa divulgar mais" 40% a 69,9...% →
     * "Sessão Mediana" 70% a 89,9...% → "Casa Cheia" 90% a 100% → "Sessão
     * Esgotada - Sucesso de bilheteria!" texto descritivo da classificação da
     * sessão
     */
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

    /**
     * Calcula o preço do ingresso de acordo com o setor (definido pela fileira)
     * e o tipo de ingresso. Setores e preço cheio: fileiras 0-1 (frente): R$
     * 15,00 fileiras 2-7 (meio): R$ 25,00 fileiras 8-9 (VIP): R$ 35,00 Se tipo
     * == 2 (meia-entrada), o valor do setor é dividido por 2.
     *
     * fileira índice da fileira (0 a 9), usado para determinar o setor/preço
     * base tipo de ingresso: 1 = inteira, 2 = meia preço final do ingresso, em
     * reais
     */
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

    /**
     * Imprime um resumo final da sessão no console, contendo: número de
     * ingressos vendidos, valor total da bilheteria, percentual de ocupação da
     * sala e a classificação textual da sessão
     */
    public void resumo() {
        double ocupacao = percentualOcupacao();

        System.out.println("\n\t===== RESUMO =====");
        System.out.println("Ingressos vendidos: " + ingressosVendidos());
        System.out.printf("Bilheteria: R$ %.2f\n", getBilheteria());
        System.out.printf("Ocupação: %.2f%%\n", ocupacao);
        System.out.println(classificacao(ocupacao) + "\n");
    }
}

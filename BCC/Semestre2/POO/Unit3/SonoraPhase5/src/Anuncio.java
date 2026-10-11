/**
 * Anuncio NAO herda de Conteudo (nao faz parte do acervo, nao entra em playlist)
 * e NAO herda de Plano. Ele so cumpre dois contratos:
 *  - Reproduzivel: toca e tem duracao (como um conteudo);
 *  - Faturavel: gera receita (como um plano).
 * Uma classe so pode ter UMA superclasse, mas pode implementar VARIAS interfaces.
 */
public class Anuncio implements Faturavel, Reproduzivel {

    private String anunciante;
    private String titulo;
    private int duracaoSegundos;
    private double valorPorMilImpressoes;
    private int impressoes; // comeca em 0; so reproduzir() altera (sem setter)

    public Anuncio(String anunciante, String titulo, int duracaoSegundos, double valorPorMilImpressoes) {
        if (anunciante == null || anunciante.trim().isEmpty()) {
            throw new IllegalArgumentException("O anunciante nao pode ser nulo/vazio.");
        }
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("O titulo do anuncio nao pode ser nulo/vazio.");
        }
        if (duracaoSegundos <= 0) {
            throw new IllegalArgumentException(
                    "Duracao invalida: " + duracaoSegundos + ". A duracao deve ser maior que zero.");
        }
        if (valorPorMilImpressoes <= 0) {
            throw new IllegalArgumentException(
                    "Valor por mil impressoes invalido: " + valorPorMilImpressoes + ". Deve ser maior que zero.");
        }
        this.anunciante = anunciante;
        this.titulo = titulo;
        this.duracaoSegundos = duracaoSegundos;
        this.valorPorMilImpressoes = valorPorMilImpressoes;
        this.impressoes = 0;
    }

    public String getAnunciante() {
        return anunciante;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getValorPorMilImpressoes() {
        return valorPorMilImpressoes;
    }

    public int getImpressoes() {
        return impressoes;
    }

    @Override
    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    @Override
    public void reproduzir() {
        impressoes++;
        System.out.println("[Anuncio] " + titulo + " - oferecimento de " + anunciante);
    }

    /** O que o anunciante paga: impressoes / 1000 * valor por mil. */
    @Override
    public double calcularMensalidade() {
        return impressoes / 1000.0 * valorPorMilImpressoes;
    }

    @Override
    public String toString() {
        return titulo + " (" + anunciante + ") - " + impressoes + " impressoes";
    }
}
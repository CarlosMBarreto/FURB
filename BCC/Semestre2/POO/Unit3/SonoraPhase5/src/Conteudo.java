/**
 * Superclasse abstrata de tudo que o Sonora sabe reproduzir (Musica, Podcast).
 * Nao existe "conteudo generico": por isso a classe e abstrata.
 * Implementa Reproduzivel: ja tem getDuracaoSegundos() e reproduzir(); o
 * getDuracaoFormatada() vem pronto (default) de Cronometravel.
 */
public abstract class Conteudo implements Reproduzivel {

    private static int contador = 0;

    private int id;
    private String titulo;
    private int duracaoSegundos;
    private int reproducoes;

    protected Conteudo(String titulo, int duracaoSegundos) {
        this.id = ++contador;
        setTitulo(titulo);
        setDuracaoSegundos(duracaoSegundos);
        this.reproducoes = 0;
    }

    public int getId() {
        return id;
    }

    // protected: as subclasses podem usar, o resto do sistema nao
    protected void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("O titulo nao pode ser nulo/vazio.");
        }
        this.titulo = titulo;
    }

    @Override
    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public void setDuracaoSegundos(int duracaoSegundos) {
        if (duracaoSegundos <= 0) {
            throw new IllegalArgumentException(
                    "Duracao invalida: " + duracaoSegundos + ". A duracao deve ser maior que zero.");
        }
        this.duracaoSegundos = duracaoSegundos;
    }

    // getter apenas: so reproduzir() pode alterar o contador
    public int getReproducoes() {
        return reproducoes;
    }

    /** Quem assina o conteudo (artista/album, apresentador/episodio...). */
    public abstract String getCreditos();

    /**
     * final: uma subclasse que sobrescrevesse e esquecesse de incrementar
     * deixaria o contador de reproducoes errado.
     */
    @Override
    public final void reproduzir() {
        reproducoes++;
        System.out.println("Reproduzindo: " + titulo + " - " + getCreditos());
    }

    @Override
    public String toString() {
        return "[" + getId() + "] " + titulo + " (" + duracaoSegundos + "s)";
    }
}
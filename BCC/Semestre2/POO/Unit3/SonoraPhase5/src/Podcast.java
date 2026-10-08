public class Podcast extends Conteudo {

    private String apresentador;
    private int numeroEpisodio;

    public Podcast(String titulo, int duracaoSegundos, String apresentador, int numeroEpisodio) {
        super(titulo, duracaoSegundos);
        setApresentador(apresentador);
        setNumeroEpisodio(numeroEpisodio);
    }

    public String getApresentador() {
        return apresentador;
    }

    public void setApresentador(String apresentador) {
        if (apresentador == null || apresentador.trim().isEmpty()) {
            throw new IllegalArgumentException("O apresentador do podcast nao pode ser nulo/vazio.");
        }
        this.apresentador = apresentador;
    }

    public int getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(int numeroEpisodio) {
        if (numeroEpisodio < 1) {
            throw new IllegalArgumentException(
                    "Numero de episodio invalido: " + numeroEpisodio + ". Deve ser maior ou igual a 1.");
        }
        this.numeroEpisodio = numeroEpisodio;
    }

    @Override
    public String getCreditos() {
        return "Ep. " + numeroEpisodio + " com " + apresentador;
    }

    @Override
    public String toString() {
        return super.toString() + " - Ep. " + numeroEpisodio + " (" + apresentador + ")";
    }
}

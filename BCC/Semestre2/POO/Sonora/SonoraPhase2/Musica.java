public class Musica {

    private static int contadorId = 1;

    private int id;
    private String titulo;
    private String artista;
    private int duracaoSegundos;
    private int reproducoes;

    public Musica(String titulo, String artista, int duracaoSegundos) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("O titulo da musica nao pode ser nulo/vazio.");
        }
        if (artista == null || artista.trim().isEmpty()) {
            throw new IllegalArgumentException("O artista da musica nao pode ser nulo/vazio.");
        }
        if (duracaoSegundos <= 0) {
            throw new IllegalArgumentException("Duracao invalida: " + duracaoSegundos + ". A duracao deve ser maior que zero.");
        }
        this.id = contadorId++;
        this.titulo = titulo;
        this.artista = artista;
        this.duracaoSegundos = duracaoSegundos;
        this.reproducoes = 0;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public int getReproducoes() {
        return reproducoes;
    }

    public void reproduzir() {
        reproducoes++;
    }

    public String getDuracaoFormatada() {
        int minutos = duracaoSegundos / 60;
        int segundos = duracaoSegundos % 60;
        return String.format("%02d:%02d", minutos, segundos);
    }
}
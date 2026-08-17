public class Artista {

    private static int contadorId = 1;

    private int idArtista;
    private String nomeArtista;
    private String generoMusical;
    private String paisOrigem;

    public Artista(String nomeArtista, String generoMusical, String paisOrigem) {
        this.idArtista = contadorId++;
        this.nomeArtista = nomeArtista;
        this.generoMusical = generoMusical;
        this.paisOrigem = paisOrigem;
    }

    public Artista(String nomeArtista) {
        this(nomeArtista, "Não informado", "Não informado");
    }

    public int getIdArtista() {
        return idArtista;
    }

    public String getNomeArtista() {
        return nomeArtista;
    }

    public void setNomeArtista(String nomeArtista) {
        this.nomeArtista = nomeArtista;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }
}
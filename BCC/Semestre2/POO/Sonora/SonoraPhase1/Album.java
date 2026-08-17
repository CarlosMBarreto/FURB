public class Album {

    private static int contadorId = 1;

    private int idAlbum;
    private String nomeAlbum;
    private int anoLancamento;
    private Artista artista;

    public Album(String nomeAlbum, int anoLancamento, Artista artista) {
        this.idAlbum = contadorId++;
        this.nomeAlbum = nomeAlbum;
        this.anoLancamento = anoLancamento;
        this.artista = artista;
    }

    public int getIdAlbum() {
        return idAlbum;
    }

    public String getNomeAlbum() {
        return nomeAlbum;
    }

    public void setNomeAlbum(String nomeAlbum) {
        this.nomeAlbum = nomeAlbum;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }
}
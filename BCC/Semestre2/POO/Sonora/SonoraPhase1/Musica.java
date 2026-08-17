public class Musica {

    private static int contadorId = 1;

    private int idMusica;
    private String tituloMusica;
    private int minutos;
    private int segundos;
    private String letraMusica;
    private Artista artista;
    private Album album;

    public Musica(String tituloMusica, int minutos, int segundos, String letraMusica,
                  Artista artista, Album album) {
        this.idMusica = contadorId++;
        this.tituloMusica = tituloMusica;
        this.minutos = minutos;
        this.segundos = segundos;
        this.letraMusica = letraMusica;
        this.artista = artista;
        this.album = album;
    }

    public Musica(String tituloMusica, int minutos, int segundos, Artista artista, Album album) {
        this(tituloMusica, minutos, segundos, "Letra não cadastrada", artista, album);
    }

    public int getIdMusica() {
        return idMusica;
    }

    public String getTituloMusica() {
        return tituloMusica;
    }

    public void setTituloMusica(String tituloMusica) {
        this.tituloMusica = tituloMusica;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public String getLetraMusica() {
        return letraMusica;
    }

    public void setLetraMusica(String letraMusica) {
        this.letraMusica = letraMusica;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
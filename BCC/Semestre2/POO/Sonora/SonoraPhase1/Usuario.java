public class Usuario {

    private static int contadorId = 1;

    private int idUsuario;
    private String nomeUsuario;
    private String emailUsuario;
    private Playlist[] playlists = new Playlist[20];
    private int quantidadeAtual;
    private Playlist playlistAtiva;
    private int minutosDecorridos;
    private int segundosDecorridos;
    private boolean tocando;

    public Usuario(String nomeUsuario, String emailUsuario) {
        this.idUsuario = contadorId++;
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
        this.quantidadeAtual = 0;
        this.playlistAtiva = null;
        this.minutosDecorridos = 0;
        this.segundosDecorridos = 0;
        this.tocando = false;
    }

    public boolean adicionarPlaylist(Playlist playlist) {
        if (quantidadeAtual >= playlists.length) {
            return false;
        }
        playlists[quantidadeAtual] = playlist;
        quantidadeAtual++;
        return true;
    }

    public void tocarPlaylist(Playlist playlist) {
        this.playlistAtiva = playlist;
        this.minutosDecorridos = 0;
        this.segundosDecorridos = 0;
        this.tocando = true;
    }

    public void pausar() {
        this.tocando = false;
    }

    public void retomar() {
        if (playlistAtiva != null) {
            this.tocando = true;
        }
    }

    public void proxima() {
        if (playlistAtiva != null) {
            playlistAtiva.proximaMusica();
            this.minutosDecorridos = 0;
            this.segundosDecorridos = 0;
        }
    }

    public void voltar() {
        if (playlistAtiva != null) {
            playlistAtiva.musicaAnterior();
            this.minutosDecorridos = 0;
            this.segundosDecorridos = 0;
        }
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public Playlist[] getPlaylists() {
        return playlists;
    }

    public int getQuantidadeAtual() {
        return quantidadeAtual;
    }

    public Playlist getPlaylistAtiva() {
        return playlistAtiva;
    }

    public int getMinutosDecorridos() {
        return minutosDecorridos;
    }

    public int getSegundosDecorridos() {
        return segundosDecorridos;
    }

    public boolean isTocando() {
        return tocando;
    }
}
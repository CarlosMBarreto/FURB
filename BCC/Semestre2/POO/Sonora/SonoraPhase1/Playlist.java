public class Playlist {

    private static int contadorId = 1;

    private int idPlaylist;
    private String nomePlaylist;
    private Musica[] musicas = new Musica[50];
    private int quantidadeAtual;
    private int posicaoAtual;

    public Playlist(String nomePlaylist) {
        this.idPlaylist = contadorId++;
        this.nomePlaylist = nomePlaylist;
        this.quantidadeAtual = 0;
        this.posicaoAtual = -1;
    }

    public boolean adicionarMusica(Musica musica) {
        if (quantidadeAtual >= musicas.length) {
            return false;
        }
        musicas[quantidadeAtual] = musica;
        quantidadeAtual++;
        return true;
    }

    public Musica getMusicaAtual() {
        if (posicaoAtual < 0 || posicaoAtual >= quantidadeAtual) {
            return null;
        }
        return musicas[posicaoAtual];
    }

    public Musica proximaMusica() {
        if (quantidadeAtual == 0) {
            return null;
        }
        if (posicaoAtual < quantidadeAtual - 1) {
            posicaoAtual++;
        }
        return getMusicaAtual();
    }

    public Musica musicaAnterior() {
        if (quantidadeAtual == 0) {
            return null;
        }
        if (posicaoAtual > 0) {
            posicaoAtual--;
        }
        return getMusicaAtual();
    }

    public int getIdPlaylist() {
        return idPlaylist;
    }

    public String getNomePlaylist() {
        return nomePlaylist;
    }

    public void setNomePlaylist(String nomePlaylist) {
        this.nomePlaylist = nomePlaylist;
    }

    public Musica[] getMusicas() {
        return musicas;
    }

    public int getQuantidadeAtual() {
        return quantidadeAtual;
    }

    public int getPosicaoAtual() {
        return posicaoAtual;
    }
}
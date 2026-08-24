public class Playlist {

    private static final int CAPACIDADE = 100;

    private String nome;
    private Usuario dono;
    private Musica[] musicas = new Musica[CAPACIDADE];
    private int quantidade;

    public Playlist(String nome, Usuario dono) {
        this.nome = nome;
        this.dono = dono;
        this.quantidade = 0;
    }

    public String getNome() {
        return nome;
    }

    public Usuario getDono() {
        return dono;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public boolean adicionar(Musica musica) {
        if (musica == null) {
            return false;
        }
        if (quantidade >= CAPACIDADE) {
            return false;
        }
        musicas[quantidade] = musica;
        quantidade++;
        return true;
    }

    public Musica getNaPosicao(int indice) {
        if (indice < 0 || indice >= quantidade) {
            return null;
        }
        return musicas[indice];
    }

    public boolean removerNaPosicao(int indice) {
        if (indice < 0 || indice >= quantidade) {
            return false;
        }
        for (int i = indice; i < quantidade - 1; i++) {
            musicas[i] = musicas[i + 1];
        }
        musicas[quantidade - 1] = null;
        quantidade--;
        return true;
    }

    public int getDuracaoTotalSegundos() {
        int total = 0;
        for (int i = 0; i < quantidade; i++) {
            total += musicas[i].getDuracaoSegundos();
        }
        return total;
    }

    public void reproduzirTudo() {
        for (int i = 0; i < quantidade; i++) {
            musicas[i].reproduzir();
        }
    }

    public boolean contemMusica(Musica musica) {
        for (int i = 0; i < quantidade; i++) {
            if (musicas[i].equals(musica)) {
                return true;
            }
        }
        return false;
    }
}

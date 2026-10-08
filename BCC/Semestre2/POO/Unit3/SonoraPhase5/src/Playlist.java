import java.util.ArrayList;

public class Playlist {

    private String nome;
    private Usuario dono;
    private ArrayList<Conteudo> musicas = new ArrayList<>();

    public Playlist(String nome, Usuario dono) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome da playlist nao pode ser nulo/vazio.");
        }
        if (dono == null) {
            throw new IllegalArgumentException("O dono da playlist nao pode ser nulo.");
        }
        this.nome = nome;
        this.dono = dono;
    }

    public String getNome() {
        return nome;
    }

    public Usuario getDono() {
        return dono;
    }

    public int getQuantidade() {
        return musicas.size();
    }

    public boolean adicionar(Conteudo musica) {
        if (musica == null) {
            throw new IllegalArgumentException("A musica nao pode ser nula.");
        }
        return musicas.add(musica);
    }

    public Conteudo getNaPosicao(int indice) {
        if (indice < 0 || indice >= musicas.size()) {
            throw new IndexOutOfBoundsException("Posicao invalida: " + indice + ". Indice esperado: 0 a " + (musicas.size() - 1) + ".");
        }
        return musicas.get(indice);
    }

    public boolean removerNaPosicao(int indice) {
        if (indice < 0 || indice >= musicas.size()) {
            throw new IndexOutOfBoundsException("Posicao invalida: " + indice + ". Indice esperado: 0 a " + (musicas.size() - 1) + ".");
        }
        musicas.remove(indice);
        return true;
    }

    public int getDuracaoTotalSegundos() {
        int total = 0;
        for (Conteudo musica : musicas) {
            total += musica.getDuracaoSegundos();
        }
        return total;
    }

    public void reproduzirTudo() {
        for (Conteudo musica : musicas) {
            musica.reproduzir();
        }
    }

    public boolean contemMusica(Conteudo conteudo) {
        return musicas.contains(conteudo);
    }
}
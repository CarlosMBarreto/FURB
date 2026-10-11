import java.util.ArrayList;

public class Playlist {

    private String nome;
    private Usuario dono;
    private ArrayList<Conteudo> itens = new ArrayList<>();

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
        return itens.size();
    }

    public boolean adicionar(Conteudo conteudo) {
        if (conteudo == null) {
            throw new IllegalArgumentException("O conteudo nao pode ser nulo.");
        }
        return itens.add(conteudo);
    }

    public Conteudo getNaPosicao(int indice) {
        if (indice < 0 || indice >= itens.size()) {
            throw new IndexOutOfBoundsException("Posicao invalida: " + indice + ". Indice esperado: 0 a " + (itens.size() - 1) + ".");
        }
        return itens.get(indice);
    }

    public boolean removerNaPosicao(int indice) {
        if (indice < 0 || indice >= itens.size()) {
            throw new IndexOutOfBoundsException("Posicao invalida: " + indice + ". Indice esperado: 0 a " + (itens.size() - 1) + ".");
        }
        itens.remove(indice);
        return true;
    }

    public int getDuracaoTotalSegundos() {
        int total = 0;
        for (Conteudo item : itens) {
            total += item.getDuracaoSegundos(); // sem if: cada objeto responde do seu jeito
        }
        return total;
    }

    public void reproduzirTudo() {
        for (Conteudo item : itens) {
            item.reproduzir(); // tipo dinamico decide qual getCreditos() roda
        }
    }

    /** Fila para o Plataforma.tocarPlaylist: copia dos itens como Reproduzivel. */
    public ArrayList<Reproduzivel> getItensReproduziveis() {
        return new ArrayList<Reproduzivel>(itens);
    }

    public boolean contemMusica(Conteudo conteudo) {
        return itens.contains(conteudo);
    }
}
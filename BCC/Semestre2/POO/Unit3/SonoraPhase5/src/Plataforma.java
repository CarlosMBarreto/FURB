import java.util.ArrayList;

public class Plataforma {

    // Um unico acervo guarda Musica e Podcast (variavel polimorfica: tipo estatico Conteudo)
    private ArrayList<Conteudo> musicas = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Anuncio> anuncios = new ArrayList<>();

    /** Cadastra qualquer Conteudo (Musica ou Podcast). Nome mantido da fase anterior. */
    public boolean cadastrarMusica(Conteudo conteudo) {
        if (conteudo == null) {
            return false;
        }
        musicas.add(conteudo);
        return true;
    }

    public boolean cadastrarUsuario(Usuario usuario) {
        if (usuario == null) {
            return false;
        }
        usuarios.add(usuario);
        return true;
    }

    public boolean cadastrarAnuncio(Anuncio anuncio) {
        if (anuncio == null) {
            return false;
        }
        anuncios.add(anuncio);
        return true;
    }

    public Conteudo buscarMusicaPorId(int id) {
        for (Conteudo conteudo : musicas) {
            if (conteudo.getId() == id) {
                return conteudo;
            }
        }
        return null;
    }

    public Conteudo buscarMusica(String titulo) {
        for (Conteudo conteudo : musicas) {
            if (conteudo.getTitulo().equalsIgnoreCase(titulo)) {
                return conteudo;
            }
        }
        return null;
    }

    public int getTotalMusicas() {
        return musicas.size();
    }

    public int getTotalUsuarios() {
        return usuarios.size();
    }

    public int getTotalAnuncios() {
        return anuncios.size();
    }

    public Conteudo getMusicaNoAcervo(int indice) {
        if (indice < 0 || indice >= musicas.size()) {
            return null;
        }
        return musicas.get(indice);
    }

    public Usuario getUsuarioCadastrado(int indice) {
        if (indice < 0 || indice >= usuarios.size()) {
            return null;
        }
        return usuarios.get(indice);
    }

    public Anuncio getAnuncioCadastrado(int indice) {
        if (indice < 0 || indice >= anuncios.size()) {
            return null;
        }
        return anuncios.get(indice);
    }

    /**
     * Receita = mensalidade dos planos + valor cobrado dos anunciantes.
     * Um unico laco, sem instanceof e sem cast: Plano e Anuncio sao Faturavel.
     */
    public double calcularReceitaMensal() {
        ArrayList<Faturavel> cobrancas = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            cobrancas.add(usuario.getPlano());
        }
        for (Anuncio anuncio : anuncios) {
            cobrancas.add(anuncio);
        }

        double total = 0;
        for (Faturavel f : cobrancas) {
            total += f.calcularMensalidade();
        }
        return total;
    }

    /**
     * Aqui o instanceof com downcast e legitimo: getApresentador() so existe em
     * Podcast, e o tipo estatico do item (Conteudo) nao enxerga esse metodo.
     */
    public void listarEpisodiosDe(String apresentador) {
        if (apresentador == null || apresentador.trim().isEmpty()) {
            throw new IllegalArgumentException("O apresentador nao pode ser nulo/vazio.");
        }
        int encontrados = 0;
        for (Conteudo conteudo : musicas) {
            if (conteudo instanceof Podcast) {
                Podcast podcast = (Podcast) conteudo; // downcast
                if (podcast.getApresentador().equalsIgnoreCase(apresentador.trim())) {
                    System.out.println(podcast);
                    encontrados++;
                }
            }
        }
        if (encontrados == 0) {
            System.out.println("Nenhum episodio encontrado para " + apresentador + ".");
        }
    }

    /**
     * Monta uma fila de Reproduzivel (conteudos + anuncios) e toca.
     * Se o plano do ouvinte tem anuncios e ha anuncios cadastrados, intercala
     * um anuncio a cada dois itens, em rodizio. Sem instanceof: a decisao vem
     * de temAnuncios() e quem toca e o tipo dinamico de cada item.
     */
    public void tocarPlaylist(Usuario ouvinte, Playlist playlist) {
        if (ouvinte == null) {
            throw new IllegalArgumentException("O ouvinte nao pode ser nulo.");
        }
        if (playlist == null) {
            throw new IllegalArgumentException("A playlist nao pode ser nula.");
        }

        ArrayList<Reproduzivel> itens = playlist.getItensReproduziveis();
        boolean comAnuncios = ouvinte.getPlano().temAnuncios() && !anuncios.isEmpty();

        ArrayList<Reproduzivel> fila = new ArrayList<>();
        int proximoAnuncio = 0;
        for (int i = 0; i < itens.size(); i++) {
            fila.add(itens.get(i));
            if (comAnuncios && (i + 1) % 2 == 0) {
                fila.add(anuncios.get(proximoAnuncio));
                proximoAnuncio = (proximoAnuncio + 1) % anuncios.size(); // rodizio
            }
        }

        System.out.println("Tocando \"" + playlist.getNome() + "\" para " + ouvinte.getNome() + ":");
        for (Reproduzivel item : fila) {
            System.out.print("(" + item.getDuracaoFormatada() + ") ");
            item.reproduzir();
        }
    }
}
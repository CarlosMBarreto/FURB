public class Plataforma {

    private static final int CAPACIDADE = 500;

    private Musica[] musicas = new Musica[CAPACIDADE];
    private int totalMusicas;

    private Usuario[] usuarios = new Usuario[CAPACIDADE];
    private int totalUsuarios;

    public boolean cadastrarMusica(Musica musica) {
        if (musica == null) {
            return false;
        }
        if (totalMusicas >= CAPACIDADE) {
            return false;
        }
        musicas[totalMusicas] = musica;
        totalMusicas++;
        return true;
    }

    public boolean cadastrarUsuario(Usuario usuario) {
        if (usuario == null) {
            return false;
        }
        if (totalUsuarios >= CAPACIDADE) {
            return false;
        }
        usuarios[totalUsuarios] = usuario;
        totalUsuarios++;
        return true;
    }

    public Musica buscarMusicaPorId(int id) {
        for (int i = 0; i < totalMusicas; i++) {
            if (musicas[i].getId() == id) {
                return musicas[i];
            }
        }
        return null;
    }

    public Musica buscarMusica(String titulo) {
        for (int i = 0; i < totalMusicas; i++) {
            if (musicas[i].getTitulo().equalsIgnoreCase(titulo)) {
                return musicas[i];
            }
        }
        return null;
    }

    public int getTotalMusicas() {
        return totalMusicas;
    }

    public int getTotalUsuarios() {
        return totalUsuarios;
    }

    public Musica getMusicaNoAcervo(int indice) {
        if (indice < 0 || indice >= totalMusicas) {
            return null;
        }
        return musicas[indice];
    }

    public Usuario getUsuarioCadastrado(int indice) {
        if (indice < 0 || indice >= totalUsuarios) {
            return null;
        }
        return usuarios[indice];
    }
}
import java.util.ArrayList;

public class Plataforma {

    private ArrayList<Musica> musicas = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public boolean cadastrarMusica(Musica musica) {
        if (musica == null) {
            return false;
        }
        musicas.add(musica);
        return true;
    }

    public boolean cadastrarUsuario(Usuario usuario) {
        if (usuario == null) {
            return false;
        }
        usuarios.add(usuario);
        return true;
    }

    public Musica buscarMusicaPorId(int id) {
        for (Musica musica : musicas) {
            if (musica.getId() == id) {
                return musica;
            }
        }
        return null;
    }

    public Musica buscarMusica(String titulo) {
        for (Musica musica : musicas) {
            if (musica.getTitulo().equalsIgnoreCase(titulo)) {
                return musica;
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

    public Musica getMusicaNoAcervo(int indice) {
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
}
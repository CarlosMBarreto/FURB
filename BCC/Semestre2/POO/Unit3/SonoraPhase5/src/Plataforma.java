import java.util.ArrayList;

public class Plataforma {

    private ArrayList<Conteudo> musicas = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();

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

    public double calcularReceitaMensal() {
        double total = 0;
        for (Usuario usuario : usuarios) {
            total = usuario.getPlano().getMensalidade();
        }
        return total;
    }
}
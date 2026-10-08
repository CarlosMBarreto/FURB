import java.util.ArrayList;

public class Usuario {

    private static int contadorId = 1;

    private int id;
    private String nome;
    private String email;
    private ArrayList<Usuario> seguindo = new ArrayList<>();
    private Plano plano;

    public Usuario(String nome, String email) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do usuario nao pode ser nulo/vazio.");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("O email do usuario nao pode ser nulo/vazio.");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException("O email do usuario precisa conter '@'.");
        }
        this.id = contadorId++;
        this.nome = nome;
        this.email = email;
        this.plano = new PlanoGratuito();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void seguir(Usuario outro) {
        if (outro == null) {
            throw new IllegalArgumentException("O usuario a seguir nao pode ser nulo.");
        }
        if (outro == this) {
            throw new IllegalArgumentException("Um usuario nao pode seguir a si mesmo.");
        }
        if (seguindo.contains(outro)) {
            throw new IllegalArgumentException("Voce ja segue " + outro.getNome() + ".");
        }
        seguindo.add(outro);
    }

    public void deixarDeSeguir(Usuario outro) {
        if (outro == null) {
            throw new IllegalArgumentException("O usuario a deixar de seguir nao pode ser nulo.");
        }
        if (!seguindo.contains(outro)) {
            throw new IllegalArgumentException("Voce nao segue " + outro.getNome() + ".");
        }
        seguindo.remove(outro);
    }

    public int getQuantidadeSeguindo() {
        return seguindo.size();
    }

    public Usuario getSeguindoNaPosicao(int indice) {
        if (indice < 0 || indice >= seguindo.size()) {
            throw new IndexOutOfBoundsException(
                    "Posicao invalida: " + indice + ". Indice esperado: 0 a " + (seguindo.size() - 1) + ".");
        }
        return seguindo.get(indice);
    }

    public Plano getPlano() {
        return plano;
    }

    public void assinar(Plano novoPlano) {
        if (novoPlano == null) {
            throw new IllegalArgumentException("O plano nao pode ser nulo.");
        }
        this.plano = novoPlano;
    }
}

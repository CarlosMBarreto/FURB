public class Usuario {

    private static int contadorId = 1;

    private int id;
    private String nome;
    private String email;

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
}
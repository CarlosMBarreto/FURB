public class Usuario {

    private static int contadorId = 1;

    private int id;
    private String nome;
    private String email;

    public Usuario(String nome, String email) {
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
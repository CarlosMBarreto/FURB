public class Aluno {
    String nome;
    double nota;

    public Aluno(String nome, double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public String situacao() {
        if (nota >= 7.0) {
            return "Aprovado";
        } else if (nota >= 4.0 && nota < 7.0) {
            return "Recuperacao";
        }
        return "Reprovado";
    }
}

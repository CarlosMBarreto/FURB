/**
 * Superclasse abstrata dos planos de assinatura (generalizacao, rodada 1).
 * Guarda o que e igual nos tres planos: nome, maxDispositivos e o formato do resumo.
 * O que muda de plano para plano (mensalidade e anuncios) e abstrato.
 */
public abstract class Plano {

    private String nome;
    private int maxDispositivos;

    protected Plano(String nome, int maxDispositivos) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do plano nao pode ser nulo/vazio.");
        }
        if (maxDispositivos < 1) {
            throw new IllegalArgumentException("O plano deve permitir ao menos 1 dispositivo.");
        }
        this.nome = nome;
        this.maxDispositivos = maxDispositivos;
    }

    public String getNome() {
        return nome;
    }

    public int getMaxDispositivos() {
        return maxDispositivos;
    }

    // algoritmo diferente em cada plano: cada subclasse concreta decide
    public abstract boolean temAnuncios();

    public abstract double calcularMensalidade();

    /** final: o formato do resumo e o mesmo para qualquer plano; so o calculo muda. */
    public final String resumo() {
        return nome + ": R$ " + calcularMensalidade()
                + " por mes, " + maxDispositivos + " dispositivo(s)";
    }
}

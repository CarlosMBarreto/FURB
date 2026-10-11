/**
 * Superclasse abstrata dos planos de assinatura (generalizacao, rodada 1).
 * Guarda o que e igual nos tres planos: nome, maxDispositivos e o formato do resumo.
 * O que muda de plano para plano: temAnuncios() (abstrato aqui) e
 * calcularMensalidade() (contrato da interface Faturavel).
 */
public abstract class Plano implements Faturavel {

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

    // calcularMensalidade() vem da interface Faturavel: Plano e abstrata, entao nao
    // precisa implementar; a obrigacao desce para as subclasses concretas.

    /** final: o formato do resumo e o mesmo para qualquer plano; so o calculo muda. */
    public final String resumo() {
        return nome + ": R$ " + calcularMensalidade()
                + " por mes, " + maxDispositivos + " dispositivo(s)";
    }
}
package BCC.Semestre2.POO.Unit5.RangoJa;

import java.util.Locale;

public class Cliente {

    private static final double CASHBACK_INDICACAO = 10.00;

    private String nome;
    private String email;
    private int idade;
    private double saldoCashback;
    private Cliente indicadoPor; // associação reflexiva (0..1): quem indicou este cliente

    // US01 - Cadastro
    public Cliente(String nome, String email, int idade) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome inválido (vazio ou nulo).");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("E-mail inválido (vazio ou nulo).");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException("O e-mail deve conter '@'.");
        }
        this.nome = nome;
        this.email = email;
        setIdade(idade); // reaproveita a validação do setter
        this.saldoCashback = 0.0;
    }

    // US02 - Indique um amigo
    public Cliente(String nome, String email, int idade, Cliente indicadoPor) {
        this(nome, email, idade);
        if (indicadoPor == null) {
            throw new IllegalArgumentException("O cliente indicador não pode ser nulo.");
        }
        this.indicadoPor = indicadoPor;
        indicadoPor.creditarCashback(CASHBACK_INDICACAO);
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade < 0 || idade > 120) {
            throw new IllegalArgumentException("Idade inválida: deve estar entre 0 e 120.");
        }
        this.idade = idade;
    }

    public double getSaldoCashback() {
        return saldoCashback;
    }

    public Cliente getIndicadoPor() {
        return indicadoPor;
    }

    public boolean isMaiorDeIdade() {
        return idade >= 18;
    }

    // US03 - Usar o cashback
    public void creditarCashback(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor a creditar deve ser maior que zero.");
        }
        this.saldoCashback += valor;
    }

    public void usarCashback(double valor) throws SaldoInsuficienteException {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor a usar deve ser maior que zero.");
        }
        if (valor > saldoCashback) {
            throw new SaldoInsuficienteException(saldoCashback, valor);
        }
        this.saldoCashback -= valor;
    }

    // US04 - Identificação
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cliente)) {
            return false;
        }
        Cliente outro = (Cliente) obj;
        return this.email.equalsIgnoreCase(outro.email);
    }

    // Não está no diagrama, mas é obrigatório manter hashCode coerente com equals
    // (senão o Cliente se comporta mal em HashSet/HashMap).
    @Override
    public int hashCode() {
        return email.toLowerCase(Locale.ROOT).hashCode();
    }

    @Override
    public String toString() {
        return nome + " " + email;
    }
}

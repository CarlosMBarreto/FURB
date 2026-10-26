package BCC.Semestre2.POO.Unit5.RangoJa;

public class Cliente {

    private static final double BONUS_INDICACAO = 10.00;
    private static final int IDADE_MAXIMA = 120;
    private static final int MAIORIDADE = 18;

    private final String nome;
    private final String email;
    private int idade;
    private final Cliente indicadoPor;
    private double saldoCashback;

    public Cliente(String nome, String email, int idade) {
        this(nome, email, idade, null, false);
    }

    public Cliente(String nome, String email, int idade, Cliente indicadoPor) {
        this(nome, email, idade, validarIndicador(indicadoPor), true);
    }

    private Cliente(String nome, String email, int idade, Cliente indicadoPor, boolean comIndicador) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("E-mail inválido");
        }
        validarIdade(idade);
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.indicadoPor = indicadoPor;
        if (comIndicador) {
            indicadoPor.creditarCashback(BONUS_INDICACAO);
        }
    }

    private static Cliente validarIndicador(Cliente indicador) {
        if (indicador == null) {
            throw new IllegalArgumentException("Indicador não pode ser nulo");
        }
        return indicador;
    }

    private static void validarIdade(int idade) {
        if (idade < 0 || idade > IDADE_MAXIMA) {
            throw new IllegalArgumentException("Idade deve estar entre 0 e " + IDADE_MAXIMA);
        }
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
        validarIdade(idade);
        this.idade = idade;
    }

    public boolean isMaiorDeIdade() {
        return idade >= MAIORIDADE;
    }

    public Cliente getIndicadoPor() {
        return indicadoPor;
    }

    public double getSaldoCashback() {
        return saldoCashback;
    }

    public void creditarCashback(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser positivo");
        }
        saldoCashback += valor;
    }

    public void usarCashback(double valor) throws SaldoInsuficienteException {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser positivo");
        }
        if (valor > saldoCashback) {
            throw new SaldoInsuficienteException(saldoCashback, valor);
        }
        saldoCashback -= valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cliente)) {
            return false;
        }
        return email.equalsIgnoreCase(((Cliente) o).email);
    }

    @Override
    public int hashCode() {
        return email.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return nome + " " + email;
    }
}

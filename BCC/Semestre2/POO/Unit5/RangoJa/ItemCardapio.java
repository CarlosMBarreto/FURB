package BCC.Semestre2.POO.Unit5.RangoJa;

public abstract class ItemCardapio {

    private final String nome;
    private double precoBase;

    protected ItemCardapio(String nome, double precoBase) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        validarPreco(precoBase);
        this.nome = nome;
        this.precoBase = precoBase;
    }

    private static void validarPreco(double preco) {
        if (preco <= 0) {
            throw new IllegalArgumentException("Preço base deve ser positivo");
        }
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        validarPreco(precoBase);
        this.precoBase = precoBase;
    }

    public abstract double calcularPreco();

    public double calcularPrecoComDesconto(double percentual) {
        if (percentual < 0 || percentual > 100) {
            throw new IllegalArgumentException("Desconto deve estar entre 0 e 100");
        }
        return calcularPreco() * (1 - percentual / 100.0);
    }

    @Override
    public String toString() {
        return nome + " - " + Moeda.formatar(calcularPreco());
    }
}

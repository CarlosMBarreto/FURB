package BCC.Semestre2.POO.Unit5.RangoJa;

import java.util.Locale;

/**
 * Classe abstrata: no cardápio não existe "item genérico",
 * só pratos, bebidas e sobremesas.
 */
public abstract class ItemCardapio {

    private String nome;
    private double precoBase;

    public ItemCardapio(String nome, double precoBase) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do item inválido (vazio ou nulo).");
        }
        validarPositivo(precoBase);
        this.nome = nome;
        this.precoBase = precoBase;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        validarPositivo(precoBase);
        this.precoBase = precoBase;
    }

    // Protegido: as subclasses também usam (volume e peso, por exemplo).
    protected void validarPositivo(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor deve ser positivo (maior que zero).");
        }
    }

    // Cada tipo de item calcula do seu jeito.
    public abstract double calcularPreco();

    // US09 - final: nenhuma subclasse consegue mudar a regra do desconto.
    // Chama calcularPreco() sem saber qual é a subclasse (polimorfismo).
    public final double calcularPrecoComDesconto(double percentual) {
        if (percentual < 0 || percentual > 100) {
            throw new IllegalArgumentException("O percentual de desconto deve estar entre 0 e 100.");
        }
        return calcularPreco() * (1 - percentual / 100.0);
    }

    @Override
    public String toString() {
        return String.format(Locale.forLanguageTag("pt-BR"), "%s - R$ %.2f", nome, calcularPreco());
    }
}

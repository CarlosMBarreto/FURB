package BCC.Semestre2.POO.Unit5.RangoJa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ItemCardapioTest {

    private ItemCardapio item;

    // ItemCardapio é abstrata: usamos uma subclasse anônima em que preço final = preço base.
    private static ItemCardapio criarItem(String nome, double precoBase) {
        return new ItemCardapio(nome, precoBase) {
            @Override
            public double calcularPreco() {
                return getPrecoBase();
            }
        };
    }

    @BeforeEach
    void montarContexto() {
        item = criarItem("Xis Salada", 39.00);
    }

    @Test
    void nomeNuloOuVazioDeveLancarExcecao() {
        assertThrows(IllegalArgumentException.class, () -> criarItem(null, 10.00));
        assertThrows(IllegalArgumentException.class, () -> criarItem("", 10.00));
    }

    @Test
    void precoBaseZeroOuNegativoDeveLancarExcecao() {
        assertThrows(IllegalArgumentException.class, () -> criarItem("Item", 0));
        assertThrows(IllegalArgumentException.class, () -> criarItem("Item", -5));
    }

    @Test
    void setPrecoBaseDeveValidarOValor() {
        assertThrows(IllegalArgumentException.class, () -> item.setPrecoBase(-1));

        item.setPrecoBase(50.00);

        assertEquals(50.00, item.getPrecoBase(), 0.001);
    }

    @Test
    void descontoNosLimitesDaFaixa() {
        assertEquals(39.00, item.calcularPrecoComDesconto(0), 0.001);
        assertEquals(0.00, item.calcularPrecoComDesconto(100), 0.001);
    }

    @Test
    void toStringDeveMostrarNomeEPrecoComDuasCasas() {
        assertEquals("Xis Salada - R$ 39,00", item.toString());
    }
}

package BCC.Semestre2.POO.Unit5.RangoJa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SobremesaTest {

    private Sobremesa pudim;

    @BeforeEach
    void montarContexto() {
        pudim = new Sobremesa("Pudim", 8.00, 150);
    }

    // ---- Caso obrigatório ----

    @Test
    void precoDeveSerProporcionalAoPeso() {
        assertEquals(12.00, pudim.calcularPreco(), 0.001);
    }

    // ---- Casos próprios ----

    @Test
    void pesoZeroOuNegativoDeveLancarExcecao() {
        assertThrows(IllegalArgumentException.class, () -> new Sobremesa("Pudim", 8.00, 0));
        assertThrows(IllegalArgumentException.class, () -> new Sobremesa("Pudim", 8.00, -50));
    }

    @Test
    void cemGramasCustamOPrecoBase() {
        assertEquals(8.00, new Sobremesa("Pudim", 8.00, 100).calcularPreco(), 0.001);
    }

    @Test
    void toStringDeveMostrarOPeso() {
        assertEquals("Pudim - R$ 12,00 (150 g)", pudim.toString());
        assertEquals(150, pudim.getPesoGramas());
    }
}

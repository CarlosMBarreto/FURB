package BCC.Semestre2.POO.Unit5.RangoJa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BebidaTest {

    private Bebida chopp;
    private Bebida refri;

    @BeforeEach
    void montarContexto() {
        chopp = new Bebida("Chopp", 12.00, 500, true);
        refri = new Bebida("Refri", 6.00, 350, false);
    }

    // ---- Caso obrigatório ----

    @Test
    void bebidaAlcoolicaTemAcrescimoDeTresReais() {
        assertEquals(15.00, chopp.calcularPreco(), 0.001);
    }

    // ---- Casos próprios ----

    @Test
    void bebidaNaoAlcoolicaCustaOPrecoBase() {
        assertEquals(6.00, refri.calcularPreco(), 0.001);
        assertFalse(refri.isAlcoolica());
        assertTrue(chopp.isAlcoolica());
    }

    @Test
    void volumeZeroOuNegativoDeveLancarExcecao() {
        assertThrows(IllegalArgumentException.class, () -> new Bebida("Suco", 5.00, 0, false));
        assertThrows(IllegalArgumentException.class, () -> new Bebida("Suco", 5.00, -300, false));
    }

    @Test
    void toStringDeveMostrarVolumeEMarcacaoAlcoolica() {
        assertEquals("Chopp - R$ 15,00 (500 ml) [alcoólica]", chopp.toString());
        assertEquals("Refri - R$ 6,00 (350 ml)", refri.toString());
        assertEquals(500, chopp.getVolumeMl());
    }
}

package BCC.Semestre2.POO.Unit5.RangoJa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PratoTest {

    private Prato pratoM;

    @BeforeEach
    void montarContexto() {
        pratoM = new Prato("Xis Salada", 30.00, 'M');
    }

    // ---- Casos obrigatórios ----

    @Test
    void tamanhoInvalidoDeveLancarExcecao() {
        assertThrows(IllegalArgumentException.class, () -> new Prato("Xis Salada", 30.00, 'X'));
    }

    @Test
    void pratoTamanhoMComDezPorCentoDeDesconto() {
        // 30,00 + 30% = 39,00; com 10% de desconto = 35,10
        assertEquals(35.10, pratoM.calcularPrecoComDesconto(10), 0.001);
    }

    @Test
    void descontoDeCentoEVinteDeveLancarExcecao() {
        assertThrows(IllegalArgumentException.class, () -> pratoM.calcularPrecoComDesconto(120));
    }

    // ---- Casos próprios ----

    @Test
    void precoDependeDoTamanho() {
        assertEquals(30.00, new Prato("Xis", 30.00, 'P').calcularPreco(), 0.001);
        assertEquals(39.00, new Prato("Xis", 30.00, 'M').calcularPreco(), 0.001);
        assertEquals(48.00, new Prato("Xis", 30.00, 'G').calcularPreco(), 0.001);
    }

    @Test
    void toStringDeveAproveitarSuperclasseEAcrescentarTamanho() {
        assertEquals("Xis Salada - R$ 39,00 (tamanho M)", pratoM.toString());
    }

    @Test
    void descontoNegativoDeveLancarExcecao() {
        assertThrows(IllegalArgumentException.class, () -> pratoM.calcularPrecoComDesconto(-5));
    }
}

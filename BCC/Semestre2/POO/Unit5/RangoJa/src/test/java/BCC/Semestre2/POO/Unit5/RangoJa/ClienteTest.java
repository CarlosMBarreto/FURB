package BCC.Semestre2.POO.Unit5.RangoJa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClienteTest {

    private Cliente ana;

    @BeforeEach
    void montarContexto() {
        ana = new Cliente("Ana Souza", "ana@furb.br", 20);
    }

    // ---- Casos obrigatórios ----

    @Test
    void clienteComIdadeNegativaDeveLancarExcecao() {
        assertThrows(IllegalArgumentException.class,
                () -> new Cliente("Ana", "ana@furb.br", -1));
    }

    @Test
    void clienteComEmailSemArrobaDeveLancarExcecao() {
        assertThrows(IllegalArgumentException.class,
                () -> new Cliente("Ana", "ana.furb.br", 20));
    }

    @Test
    void indicacaoDeveCreditarDezReaisParaOIndicador() {
        Cliente beto = new Cliente("Beto Lima", "beto@furb.br", 17, ana);

        assertEquals(10.00, ana.getSaldoCashback(), 0.001);
        assertSame(ana, beto.getIndicadoPor());
        assertEquals(0.0, beto.getSaldoCashback(), 0.001);
    }

    @Test
    void usarMaisCashbackQueOSaldoDeveLancarSaldoInsuficienteException() {
        ana.creditarCashback(10.00);

        assertThrows(SaldoInsuficienteException.class, () -> ana.usarCashback(15.00));
    }

    @Test
    void clientesComMesmoEmailIgnorandoMaiusculasDevemSerIguais() {
        Cliente outra = new Cliente("Ana S.", "ANA@FURB.BR", 30);

        assertTrue(ana.equals(outra));
        assertEquals(ana.hashCode(), outra.hashCode());
    }

    // ---- Casos próprios ----

    @Test
    void nomeNuloOuVazioDeveLancarExcecao() {
        assertThrows(IllegalArgumentException.class,
                () -> new Cliente(null, "x@furb.br", 20));
        assertThrows(IllegalArgumentException.class,
                () -> new Cliente("", "x@furb.br", 20));
    }

    @Test
    void indicadorNuloDeveLancarExcecao() {
        assertThrows(IllegalArgumentException.class,
                () -> new Cliente("Beto", "beto@furb.br", 17, null));
    }

    @Test
    void usarCashbackDentroDoSaldoDeveDescontar() throws SaldoInsuficienteException {
        ana.creditarCashback(10.00);

        ana.usarCashback(4.00);

        assertEquals(6.00, ana.getSaldoCashback(), 0.001);
    }

    @Test
    void valoresNaoPositivosDeveLancarExcecao() {
        assertThrows(IllegalArgumentException.class, () -> ana.creditarCashback(0));
        assertThrows(IllegalArgumentException.class, () -> ana.usarCashback(-1));
    }

    @Test
    void maioridadeELimitesDeIdade() {
        assertFalse(new Cliente("Beto", "beto@furb.br", 17).isMaiorDeIdade());
        assertTrue(new Cliente("Caio", "caio@furb.br", 18).isMaiorDeIdade());
        assertEquals(0, new Cliente("Bebê", "bebe@furb.br", 0).getIdade());
        assertEquals(120, new Cliente("Vovó", "vovo@furb.br", 120).getIdade());
        assertThrows(IllegalArgumentException.class, () -> ana.setIdade(121));
    }

    @Test
    void toStringDeveMostrarNomeEEmail() {
        assertEquals("Ana Souza ana@furb.br", ana.toString());
    }

    @Test
    void mensagemDaExcecaoDeveInformarSaldoEValorPedido() {
        ana.creditarCashback(10.00);

        SaldoInsuficienteException erro = assertThrows(SaldoInsuficienteException.class,
                () -> ana.usarCashback(15.00));

        assertEquals("Saldo insuficiente: disponível R$ 10,00, solicitado R$ 15,00", erro.getMessage());
        assertEquals(10.00, ana.getSaldoCashback(), 0.001);
    }

    @Test
    void clientesComEmailsDiferentesNaoSaoIguais() {
        Cliente beto = new Cliente("Beto", "beto@furb.br", 17);

        assertFalse(ana.equals(beto));
        assertFalse(ana.equals(null));
        assertNull(ana.getIndicadoPor());
    }
}

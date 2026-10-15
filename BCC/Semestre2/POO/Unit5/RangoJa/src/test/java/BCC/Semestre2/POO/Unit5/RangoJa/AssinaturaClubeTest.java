package BCC.Semestre2.POO.Unit5.RangoJa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AssinaturaClubeTest {

    private Cliente ana;

    @BeforeEach
    void montarContexto() {
        ana = new Cliente("Ana Souza", "ana@furb.br", 20);
    }

    @Test
    void abaixoDeDozeMesesNaoTemDesconto() {
        AssinaturaClube assinatura = new AssinaturaClube(ana, 19.90, 3);

        assertEquals(59.70, assinatura.calcularValorCobrar(), 0.001);
    }

    @Test
    void dozeMesesGanhamQuinzePorCentoDeDesconto() {
        AssinaturaClube assinatura = new AssinaturaClube(ana, 19.90, 12);

        assertEquals(202.98, assinatura.calcularValorCobrar(), 0.001);
    }

    @Test
    void construtorDeveValidarClienteValorEMeses() {
        assertThrows(IllegalArgumentException.class, () -> new AssinaturaClube(null, 19.90, 12));
        assertThrows(IllegalArgumentException.class, () -> new AssinaturaClube(ana, 0, 12));
        assertThrows(IllegalArgumentException.class, () -> new AssinaturaClube(ana, 19.90, 0));
    }

    @Test
    void comprovanteDefaultUsaCalcularValorCobrar() {
        Cobravel cobravel = new AssinaturaClube(ana, 19.90, 12);

        assertEquals("Valor a cobrar: R$ 202,98", cobravel.gerarComprovante());
    }
}

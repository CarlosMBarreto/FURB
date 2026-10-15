package BCC.Semestre2.POO.Unit5.RangoJa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CentralCobrancaTest {

    private CentralCobranca central;
    private Pedido pedido;            // total 64,00
    private AssinaturaClube assinatura; // 19,90 x 12 meses com 15% = 202,98

    @BeforeEach
    void montarContexto() {
        Cliente ana = new Cliente("Ana Souza", "ana@furb.br", 20);
        pedido = new Pedido(ana);
        pedido.adicionarItem(new Prato("Xis Salada", 30.00, 'M'));
        pedido.adicionarItem(new Bebida("Refri", 6.00, 350, false));
        pedido.adicionarItem(new Sobremesa("Pudim", 8.00, 150));
        assinatura = new AssinaturaClube(ana, 19.90, 12);
        central = new CentralCobranca();
    }

    // ---- Caso obrigatório ----

    @Test
    void totalAReceberSomaPedidoEAssinatura() {
        central.registrar(pedido);
        central.registrar(assinatura);

        assertEquals(266.98, central.calcularTotalAReceber(), 0.001);
        assertEquals(2, central.getQuantidadeCobrancas());
    }

    // ---- Casos próprios ----

    @Test
    void registrarCobrancaNulaDeveLancarExcecao() {
        assertThrows(IllegalArgumentException.class, () -> central.registrar(null));
    }

    @Test
    void centralVaziaTemTotalZero() {
        assertEquals(0.00, central.calcularTotalAReceber(), 0.001);
        assertEquals(0, central.getQuantidadeCobrancas());
    }

    @Test
    void relatorioTemUmaLinhaPorCobrancaETotalNoFim() {
        central.registrar(pedido);
        central.registrar(assinatura);

        String[] linhas = central.gerarRelatorio().split("\n");

        assertEquals(3, linhas.length);
        assertEquals("Valor a cobrar: R$ 64,00", linhas[0]);
        assertEquals("Valor a cobrar: R$ 202,98", linhas[1]);
        assertEquals("Total a receber: R$ 266,98", linhas[2]);
    }
}

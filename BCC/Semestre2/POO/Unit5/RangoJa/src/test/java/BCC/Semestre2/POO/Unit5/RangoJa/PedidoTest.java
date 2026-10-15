package BCC.Semestre2.POO.Unit5.RangoJa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PedidoTest {

    private Cliente ana;   // 20 anos
    private Cliente beto;  // 17 anos
    private Prato xisSalada;
    private Bebida refri;
    private Sobremesa pudim;
    private Bebida chopp;

    @BeforeEach
    void montarContexto() {
        ana = new Cliente("Ana Souza", "ana@furb.br", 20);
        beto = new Cliente("Beto Lima", "beto@furb.br", 17);
        xisSalada = new Prato("Xis Salada", 30.00, 'M');
        refri = new Bebida("Refri", 6.00, 350, false);
        pudim = new Sobremesa("Pudim", 8.00, 150);
        chopp = new Bebida("Chopp", 12.00, 500, true);
    }

    // ---- Casos obrigatórios ----

    @Test
    void pedidoComTresItensDeveCalcularSubtotalTaxaETotal() {
        Pedido pedido = new Pedido(ana);
        pedido.adicionarItem(xisSalada);
        pedido.adicionarItem(refri);
        pedido.adicionarItem(pudim);

        assertEquals(57.00, pedido.calcularSubtotal(), 0.001);
        assertEquals(7.00, pedido.calcularTaxaEntrega(), 0.001);
        assertEquals(64.00, pedido.calcularValorCobrar(), 0.001);
    }

    @Test
    void doisXisTamanhoGTemFreteGratis() {
        Prato xisG = new Prato("Xis Bacon", 40.00, 'G'); // 40 + 60% = 64,00
        Pedido pedido = new Pedido(ana);
        pedido.adicionarItem(xisG, 2);

        assertEquals(0.00, pedido.calcularTaxaEntrega(), 0.001);
        assertEquals(128.00, pedido.calcularValorCobrar(), 0.001);
    }

    @Test
    void clienteMenorDeIdadeNaoPodeAdicionarChopp() {
        Pedido pedido = new Pedido(beto);

        assertThrows(IllegalArgumentException.class, () -> pedido.adicionarItem(chopp));
        assertEquals(0, pedido.getQuantidadeItens());
    }

    @Test
    void quantidadeZeroDeveLancarExcecao() {
        Pedido pedido = new Pedido(ana);

        assertThrows(IllegalArgumentException.class, () -> pedido.adicionarItem(xisSalada, 0));
    }

    @Test
    void finalizarPedidoSemItensDeveLancarExcecao() {
        Pedido pedido = new Pedido(ana);

        assertThrows(IllegalStateException.class, pedido::finalizar);
    }

    @Test
    void finalizarPedidoDeveCreditarCincoPorCentoDoSubtotal() {
        Pedido pedido = new Pedido(ana);
        pedido.adicionarItem(xisSalada);
        pedido.adicionarItem(refri);
        pedido.adicionarItem(pudim);
        double saldoAntes = ana.getSaldoCashback();

        pedido.finalizar();

        assertEquals(2.85, ana.getSaldoCashback() - saldoAntes, 0.001);
    }

    @Test
    void doisPedidosEmSequenciaTemNumerosConsecutivos() {
        // proximoNumero é static e não volta para 1 entre testes: compara-se a diferença.
        Pedido primeiro = new Pedido(ana);
        Pedido segundo = new Pedido(beto);

        assertEquals(1, segundo.getNumero() - primeiro.getNumero());
    }

    // ---- Casos próprios ----

    @Test
    void pedidoSemClienteDeveLancarExcecao() {
        assertThrows(IllegalArgumentException.class, () -> new Pedido(null));
    }

    @Test
    void itemNuloDeveLancarExcecao() {
        Pedido pedido = new Pedido(ana);

        assertThrows(IllegalArgumentException.class, () -> pedido.adicionarItem(null));
    }

    @Test
    void adicionarItemEmPedidoFinalizadoDeveLancarExcecao() {
        Pedido pedido = new Pedido(ana);
        pedido.adicionarItem(xisSalada);
        pedido.finalizar();

        assertThrows(IllegalStateException.class, () -> pedido.adicionarItem(refri));
    }

    @Test
    void finalizarDuasVezesDeveLancarExcecaoNaSegunda() {
        Pedido pedido = new Pedido(ana);
        pedido.adicionarItem(xisSalada);
        pedido.finalizar();

        assertThrows(IllegalStateException.class, pedido::finalizar);
    }

    @Test
    void clienteMaiorDeIdadePodePedirChopp() {
        Pedido pedido = new Pedido(ana);

        pedido.adicionarItem(chopp);

        assertEquals(1, pedido.getQuantidadeItens());
    }

    @Test
    void quantidadeAdicionaOMesmoItemVariasVezes() {
        Pedido pedido = new Pedido(beto);

        pedido.adicionarItem(refri, 3);

        assertEquals(3, pedido.getQuantidadeItens());
        assertEquals(18.00, pedido.calcularSubtotal(), 0.001);
    }

    @Test
    void freteGratisComecaExatamenteEmCemReais() {
        Sobremesa torta = new Sobremesa("Torta", 50.00, 200); // 50 * 200 / 100 = 100,00
        Pedido pedido = new Pedido(ana);
        pedido.adicionarItem(torta);

        assertEquals(100.00, pedido.calcularSubtotal(), 0.001);
        assertEquals(0.00, pedido.calcularTaxaEntrega(), 0.001);
    }

    @Test
    void totalDePedidosCriadosDeveAumentarACadaPedido() {
        int antes = Pedido.getTotalPedidosCriados();

        new Pedido(ana);
        new Pedido(ana);

        assertEquals(2, Pedido.getTotalPedidosCriados() - antes);
    }

    @Test
    void pedidoFinalizadoFicaMarcadoEGuardaOCliente() {
        Pedido pedido = new Pedido(ana);
        pedido.adicionarItem(refri);
        assertFalse(pedido.isFinalizado());

        pedido.finalizar();

        assertTrue(pedido.isFinalizado());
        assertSame(ana, pedido.getCliente());
    }
}

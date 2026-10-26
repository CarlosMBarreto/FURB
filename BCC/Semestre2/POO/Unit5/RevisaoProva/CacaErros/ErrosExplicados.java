package BCC.Semestre2.POO.RevisaoProva.CacaErros;

public class ErrosExplicados {

    // B1 - Limite

// (a) - O if usa > 5, o que permite adicionar um sexto
// item, pois a lista só será considerada lotada quando
// já tiver mais de 5 itens.

// (b) - Adicionar 6 itens e verificar que foi possível
// adicionar todos. O esperado seria lançar uma exceção
// ao tentar adicionar o sexto item.

// (c) - if (itens.size() >= 5) {
//           throw new IllegalStateException("Orçamento lotado");
//       }
//       itens.add(item);


// B2 - Tipo da exceção

// (a) - O erro é usar IllegalArgumentException para um
// item repetido. O argumento pode ser válido, mas o estado
// do orçamento impede a operação. O correto é usar
// IllegalStateException.

// (b) - Adicionar uma placa e tentar adicioná-la novamente.
// Obtido: IllegalArgumentException.
// Esperado: IllegalStateException com a mensagem
// "Item já incluído no orçamento".

// (c) - if (itens.contains(item)) {
//           throw new IllegalStateException(
//               "Item já incluído no orçamento");
//       }


// B3 - Ordem das validações

// (a) - O erro é verificar se o orçamento está lotado antes
// de verificar se o item já foi adicionado. A ordem correta
// é: verificar null, repetido e depois lotado.

// (b) - Preencher o orçamento com 5 itens e tentar adicionar
// novamente um dos itens existentes.
// Obtido: "Orçamento lotado".
// Esperado: "Item já incluído no orçamento".

// (c) - if (item == null) {
//           throw new IllegalArgumentException("Item inválido");
//       }
//       if (itens.contains(item)) {
//           throw new IllegalStateException(
//               "Item já incluído no orçamento");
//       }
//       if (itens.size() >= 5) {
//           throw new IllegalStateException("Orçamento lotado");
//       }


// B4 - Remoção

// (a) - O erro é lançar a exceção quando encontra um item
// diferente daquele que deseja remover. Além disso, se a
// lista estiver vazia, o laço não executa e nenhuma exceção
// é lançada.

// (b) - Com a lista [A, B, C], tentar remover B.
// Obtido: exceção ao comparar A com B.
// Esperado: remover B e manter [A, C].
//
// Com a lista vazia, tentar remover A.
// Obtido: nenhuma exceção.
// Esperado: IllegalStateException com a mensagem
// "Item não encontrado no orçamento".

// (c) - public void removerItem(ItemSetup item) {
//           if (!itens.remove(item)) {
//               throw new IllegalStateException(
//                   "Item não encontrado no orçamento");
//           }
//       }


// B5 - Contador

// (a) - O erro é incrementar o contador antes de validar
// o preço. Se o preço for inválido, o objeto não é criado,
// mas o contador já foi incrementado, causando um salto
// na numeração dos códigos.

// (b) - Criar um item válido, depois um item com preço -10
// e, por último, outro item válido.
// Obtido: códigos 1 e 3.
// Esperado: códigos 1 e 2.

// (c) - public ItemSetup(String descricao, double precoBase) {
//           if (precoBase <= 0) {
//               throw new IllegalArgumentException(
//                   "Preço base inválido");
//           }
//           totalItens++;
//           codigo = totalItens;
//           this.descricao = descricao;
//           this.precoBase = precoBase;
//       }


// B6 - Base do cálculo

// (a) - O erro é calcular a garantia usando o preço base
// multiplicado pela quantidade, em vez de usar o preço
// calculado pelo método calcularPreco().

// (b) - Criar 3 monitores de R$ 1.200,00.
// Obtido: R$ 540,00.
// Esperado: 15% do preço calculado. Se o preço calculado
// for R$ 3.600,00, o resultado também será R$ 540,00.
// Nesse caso, os valores coincidem, mas podem ser diferentes
// quando o preço calculado incluir outros valores.

// (c) - @Override
//       public double calcularGarantiaEstendida() {
//           return calcularPreco() * 0.15;
//       }


// B7 - toString sem @Override

// (a) - O erro é escrever tostring() com o "s" minúsculo.
// O Java diferencia letras maiúsculas e minúsculas, então
// o método não sobrescreve o toString() da classe Object.

// (b) - Executar System.out.println(item).
// Obtido: uma representação padrão do objeto, como
// ItemSetup@1a2b3c.
// Esperado: o código, a descrição e o preço do item.
//
// Ao adicionar @Override, o compilador informa que o método
// não sobrescreve nenhum método da superclasse.

// (c) - @Override
//       public String toString() {
//           return getCodigo() + " - " + getDescricao()
//               + " - R$ " + calcularPreco();
//       }
//
// O @Override também vale para métodos herdados de Object,
// pois todas as classes Java herdam direta ou indiretamente
// dessa classe. A anotação verifica se o método realmente
// sobrescreve um método herdado.


// B8 - main

// (a) - Primeiro erro: declarar a variável como Peca quando
// o ideal, para trabalhar com diferentes tipos de itens,
// é utilizar o tipo mais geral ItemSetup.
//
// Segundo erro: o solicitante pode não ter sido definido,
// fazendo com que a impressão mostre "Solicitante: null".
//
// Terceiro erro: imprimir diretamente getItens() pode exibir
// os itens de forma pouco legível se as classes não tiverem
// toString() implementado corretamente.
//
// Quarto erro: adicionar a mesma placa duas vezes provoca
// IllegalStateException, pois o item já está no orçamento.

// (b) - Criar uma placa, adicioná-la e tentar adicioná-la
// novamente.
// Obtido: exceção na segunda tentativa de adicionar a placa.
// Esperado: impedir a duplicação do item.
//
// Se o solicitante não tiver sido definido, será exibido:
// "Solicitante: null".
// O esperado é exibir o nome do solicitante.

// (c) - ItemSetup placa = new Peca("Placa de vídeo", 2500.0, 1);
//       orcamento.setSolicitante("Carlos");
//       orcamento.adicionarItem(placa);
//       System.out.println("Solicitante: "
//           + orcamento.getSolicitante());
//       System.out.println(orcamento.getItens());
//
//       // Não adicionar a mesma placa novamente.
}

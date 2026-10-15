# Plano de testes – RangoJá

Plano escrito **antes** das classes de teste (Etapa 6). Cada classe de negócio tem uma classe de teste paralela, com sufixo `Test`, em `src/test/java`.

Convenções:
- **Obrigatório** = caso exigido pela atividade; **Próprio** = caso acrescentado por mim.
- Valores `double` são comparados com `assertEquals(esperado, obtido, 0.001)`.
- Exceções são verificadas com `assertThrows` + lambda (inclusive `SaldoInsuficienteException`).
- Contexto comum montado em `@BeforeEach` (clientes e itens usados em vários casos).
- `Pedido.proximoNumero` é `static` e não volta a 1 entre testes: a numeração é testada pela **diferença** entre dois pedidos, nunca pelo valor absoluto.

## ClienteTest

Contexto (`@BeforeEach`): `ana = Cliente("Ana Souza", "ana@furb.br", 20)`.

| Caso | Tipo | Descrição | Entrada | Saída esperada |
|---|---|---|---|---|
| CT01 | Obrigatório | Idade inválida (negativa) | `new Cliente("Ana", "ana@furb.br", -1)` | `IllegalArgumentException` |
| CT02 | Obrigatório | E-mail sem `@` | e-mail `"ana.furb.br"` | `IllegalArgumentException` |
| CT03 | Obrigatório | Indicação credita o indicador | `Beto` criado com `ana` como indicadora | Saldo da Ana = 10,00; `beto.getIndicadoPor()` é a Ana |
| CT04 | Obrigatório | Usar mais do que o saldo | Ana com saldo 10,00 chama `usarCashback(15)` | `SaldoInsuficienteException` |
| CT05 | Obrigatório | `equals` ignora maiúsculas/minúsculas | `"ana@furb.br"` e `"ANA@FURB.BR"` | `equals` verdadeiro |
| CT06 | Próprio | Nome nulo ou vazio | nome `null` e `""` | `IllegalArgumentException` |
| CT07 | Próprio | Indicador nulo no 2º construtor | `indicadoPor = null` | `IllegalArgumentException` |
| CT08 | Próprio | Usar cashback dentro do saldo desconta | saldo 10,00, `usarCashback(4)` | Saldo = 6,00 |
| CT09 | Próprio | Valores não positivos | `creditarCashback(0)`, `usarCashback(-1)` | `IllegalArgumentException` |
| CT10 | Próprio | Maioridade e limites de idade | idades 17, 18, 0, 120, 121 | 17 → falso; 18 → verdadeiro; 0 e 120 aceitas; 121 → `IllegalArgumentException` |
| CT11 | Próprio | `toString` | Ana | `"Ana Souza ana@furb.br"` |
| CT12 | Próprio | Mensagem da exceção | saldo 10,00, `usarCashback(15)` | `"Saldo insuficiente: disponível R$ 10,00, solicitado R$ 15,00"` e saldo continua 10,00 |
| CT13 | Próprio | `equals` com e-mails diferentes | `ana@furb.br` x `beto@furb.br` | `equals` falso |

## ItemCardapioTest

Usa uma subclasse anônima simples (preço final = preço base), pois `ItemCardapio` é abstrata.

| Caso | Tipo | Descrição | Entrada | Saída esperada |
|---|---|---|---|---|
| IT01 | Próprio | Nome obrigatório | nome `null` e `""` | `IllegalArgumentException` |
| IT02 | Próprio | Preço base positivo | preço 0 e -5 | `IllegalArgumentException` |
| IT03 | Próprio | `setPrecoBase` valida | `setPrecoBase(-1)`; depois `setPrecoBase(50)` | exceção no 1º; preço 50 no 2º |
| IT04 | Próprio | Desconto nos limites | item de 39,00, desconto 0% e 100% | 39,00 e 0,00 |
| IT05 | Próprio | `toString` | `"Xis Salada"`, 39,00 | `"Xis Salada - R$ 39,00"` |

## PratoTest

| Caso | Tipo | Descrição | Entrada | Saída esperada |
|---|---|---|---|---|
| PT01 | Obrigatório | Tamanho inválido | tamanho `'X'` | `IllegalArgumentException` |
| PT02 | Obrigatório | Preço M com desconto | prato 30,00, tamanho M, 10% | 35,10 |
| PT03 | Obrigatório | Desconto fora da faixa | desconto 120% | `IllegalArgumentException` |
| PT04 | Próprio | Preços por tamanho | prato 30,00 em P, M e G | 30,00; 39,00; 48,00 |
| PT05 | Próprio | `toString` aproveita a superclasse | Xis Salada 30,00 M | `"Xis Salada - R$ 39,00 (tamanho M)"` |
| PT06 | Próprio | Desconto negativo | desconto -5% | `IllegalArgumentException` |

## BebidaTest

| Caso | Tipo | Descrição | Entrada | Saída esperada |
|---|---|---|---|---|
| BT01 | Obrigatório | Alcoólica tem acréscimo | Chopp 12,00, 500 ml, alcoólico | 15,00 |
| BT02 | Próprio | Não alcoólica custa o preço base | Refri 6,00, 350 ml | 6,00 |
| BT03 | Próprio | Volume positivo | volume 0 | `IllegalArgumentException` |
| BT04 | Próprio | `toString` | Chopp e Refri | `"Chopp - R$ 15,00 (500 ml) [alcoólica]"` e `"Refri - R$ 6,00 (350 ml)"` |

## SobremesaTest

| Caso | Tipo | Descrição | Entrada | Saída esperada |
|---|---|---|---|---|
| ST01 | Obrigatório | Preço proporcional ao peso | Pudim 8,00 por 100 g, 150 g | 12,00 |
| ST02 | Próprio | Peso positivo | peso 0 | `IllegalArgumentException` |
| ST03 | Próprio | 100 g custa o preço base | 8,00 por 100 g, 100 g | 8,00 |
| ST04 | Próprio | `toString` | Pudim 8,00, 150 g | `"Pudim - R$ 12,00 (150 g)"` |

## PedidoTest

Contexto (`@BeforeEach`): `ana` (20 anos), `beto` (17 anos), Xis Salada 30,00 (M), Refri 6,00 (350 ml), Pudim 8,00 por 100 g (150 g), Chopp 12,00 (500 ml, alcoólico).

| Caso | Tipo | Descrição | Entrada | Saída esperada |
|---|---|---|---|---|
| PD01 | Obrigatório | Valores do pedido | Xis Salada (M) + Refri + Pudim (150 g) | Subtotal 57,00; taxa 7,00; total 64,00 |
| PD02 | Obrigatório | Frete grátis | 2 Xis de 40,00 tamanho G | Taxa 0,00; total 128,00 |
| PD03 | Obrigatório | Menor de idade pede bebida alcoólica | Beto (17) adiciona Chopp | `IllegalArgumentException` |
| PD04 | Obrigatório | Quantidade inválida | `adicionarItem(item, 0)` | `IllegalArgumentException` |
| PD05 | Obrigatório | Finalizar sem itens | `finalizar()` em pedido vazio | `IllegalStateException` |
| PD06 | Obrigatório | Cashback ao finalizar | pedido de subtotal 57,00 | Cashback da Ana aumenta 2,85 |
| PD07 | Obrigatório | Numeração sequencial | dois pedidos criados em sequência | `numero` do 2º − `numero` do 1º = 1 |
| PD08 | Próprio | Pedido sem cliente | `new Pedido(null)` | `IllegalArgumentException` |
| PD09 | Próprio | Item nulo | `adicionarItem(null)` | `IllegalArgumentException` |
| PD10 | Próprio | Adicionar em pedido finalizado | `adicionarItem` depois de `finalizar()` | `IllegalStateException` |
| PD11 | Próprio | Finalizar duas vezes | `finalizar()` duas vezes | `IllegalStateException` na 2ª |
| PD12 | Próprio | Maior de idade pode pedir chopp | Ana adiciona Chopp | aceito; 1 item |
| PD13 | Próprio | Quantidade adiciona várias vezes | `adicionarItem(refri, 3)` | `getQuantidadeItens()` = 3 |
| PD14 | Próprio | Frete grátis em exatamente 100,00 | subtotal 100,00 | Taxa 0,00 |
| PD15 | Próprio | Contador de pedidos criados | criar 2 pedidos | `getTotalPedidosCriados()` aumenta 2 |
| PD16 | Próprio | Pedido finalizado fica marcado | `finalizar()` | `isFinalizado()` falso antes e verdadeiro depois |

## AssinaturaClubeTest

| Caso | Tipo | Descrição | Entrada | Saída esperada |
|---|---|---|---|---|
| AS01 | Próprio | Sem desconto abaixo de 12 meses | 19,90 por 3 meses | 59,70 |
| AS02 | Próprio | 15% de desconto com 12 meses | 19,90 por 12 meses | 202,98 |
| AS03 | Próprio | Validações do construtor | cliente nulo; valor 0; 0 meses | `IllegalArgumentException` em cada |
| AS04 | Próprio | Comprovante (método `default`) | 19,90 por 12 meses | `"Valor a cobrar: R$ 202,98"` |

## CentralCobrancaTest

| Caso | Tipo | Descrição | Entrada | Saída esperada |
|---|---|---|---|---|
| CC01 | Obrigatório | Soma de cobranças diferentes | Pedido de 64,00 + assinatura de 19,90 por 12 meses | Total a receber 266,98 |
| CC02 | Próprio | Registrar nulo | `registrar(null)` | `IllegalArgumentException` |
| CC03 | Próprio | Central vazia | nenhuma cobrança | Total 0,00 e quantidade 0 |
| CC04 | Próprio | Relatório | pedido + assinatura | Uma linha por cobrança e `"Total a receber: R$ 266,98"` no fim |

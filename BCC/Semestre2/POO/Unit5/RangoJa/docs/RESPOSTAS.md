# Respostas – "Para ir além"

**1. Por que `proximoNumero` é `static` e `numero` não é?**

`proximoNumero` é um contador único, que pertence à classe `Pedido` e é compartilhado por todos os pedidos: só assim cada novo pedido sabe qual é o próximo número livre (e `getTotalPedidosCriados` consegue dizer quantos já existem). Já `numero` é uma característica de cada pedido: o pedido 1 e o pedido 2 precisam guardar números diferentes. Se `numero` fosse `static`, todos os pedidos teriam sempre o mesmo número.

**2. Por que `calcularPrecoComDesconto` é `final` e `calcularPreco` é `abstract`? Um mesmo método poderia ser as duas coisas?**

`calcularPreco` é `abstract` porque cada tipo de item (prato, bebida, sobremesa) calcula do seu jeito, então toda subclasse é obrigada a sobrescrever. `calcularPrecoComDesconto` é `final` porque a regra do desconto é igual para todos e nenhuma subclasse pode mudá-la; ele só aplica o percentual sobre o resultado de `calcularPreco()`, seja qual for a subclasse. Um mesmo método não pode ser as duas coisas: `abstract` obriga a sobrescrever e `final` proíbe sobrescrever, então o compilador não aceita a combinação.

**3. Se a navegação entre `Pedido` e `Cliente` fosse bidirecional, o que mudaria na classe `Cliente`?**

`Cliente` ganharia um atributo de associação com a lista dos seus pedidos (por exemplo, `ArrayList<Pedido> pedidos`), mais um método para consultar essa lista e outro para registrar um pedido novo. Além disso, o construtor de `Pedido` teria que avisar o cliente (ou o cliente teria que criar o pedido) para os dois lados ficarem sempre consistentes. No diagrama, a seta passaria a ter ponta nos dois lados e `Cliente` passaria a conhecer `Pedido`.

**4. Por que `usarCashback` precisa de `throws` e `adicionarItem` não precisa, mesmo os dois lançando exceções?**

Porque `SaldoInsuficienteException` estende `Exception` e é uma exceção verificada: o compilador obriga quem a lança a declarar `throws` e quem chama a tratar com `try/catch` ou repassar. Já `adicionarItem` lança `IllegalArgumentException` e `IllegalStateException`, que estendem `RuntimeException`, ou seja, são não verificadas: representam uso incorreto do método (argumento ruim ou estado errado) e o compilador não exige `throws` nem `try/catch`.

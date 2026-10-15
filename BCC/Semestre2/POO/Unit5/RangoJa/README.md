# RangoJá – Programação Orientada a Objetos (FURB)

Implementação das classes, do `App` e dos testes do RangoJá, seguindo o diagrama de classes e as histórias de usuário da atividade.

## Estrutura

```
RangoJa/
├── pom.xml                         # projeto Maven (Java 17+, JUnit 5)
├── README.md
├── docs/
│   ├── PLANO_DE_TESTES.md          # plano de testes (Etapa 6)
│   ├── RESPOSTAS.md                # respostas das 4 perguntas
│   └── diagrama-de-objetos.drawio  # diagrama de objetos do App (abrir no draw.io)
└── src/
    ├── main/java/BCC/Semestre2/POO/Unit5/RangoJa/
    │   ├── Cliente.java, SaldoInsuficienteException.java     (Etapa 1)
    │   ├── ItemCardapio.java, Prato.java, Bebida.java,
    │   │   Sobremesa.java                                     (Etapa 2)
    │   ├── Pedido.java                                        (Etapa 3)
    │   ├── Cobravel.java, AssinaturaClube.java,
    │   │   CentralCobranca.java                               (Etapa 4)
    │   └── App.java                                           (Etapa 5)
    └── test/java/BCC/Semestre2/POO/Unit5/RangoJa/             (Etapa 6)
        ├── ClienteTest, ItemCardapioTest, PratoTest, BebidaTest,
        │   SobremesaTest, PedidoTest, AssinaturaClubeTest,
        │   CentralCobrancaTest
```

## Como executar

**IntelliJ IDEA:** *File > Open* e escolha o `pom.xml` (ou a pasta `RangoJa`). Para rodar o programa, execute `App.main`; para os testes, clique com o botão direito em `src/test/java` > *Run 'All Tests'*.

**Linha de comando (Maven):**

```
mvn test                                                                  # roda os testes
mvn compile
java -cp target/classes BCC.Semestre2.POO.Unit5.RangoJa.App              # roda o App
```

## Observações

- O `App` pede no teclado a quantidade do prato do Beto (passo 3). Texto que não é número ou quantidade menor que 1 geram um aviso e a pergunta se repete.
- A etapa 5 do enunciado lista 7 passos (o checklist fala em 8); o `App` executa os 7 descritos.
- Além das assinaturas do diagrama, `Cliente` tem um `hashCode()` coerente com o `equals` (mesmo e-mail, ignorando maiúsculas e minúsculas), para que o cliente funcione corretamente em coleções baseadas em hash.
- Os testes de numeração de `Pedido` comparam a **diferença** entre os números dos pedidos, já que `proximoNumero` é `static` e não volta para 1 entre testes.

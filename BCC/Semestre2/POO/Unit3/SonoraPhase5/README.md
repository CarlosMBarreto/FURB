# Sonora — Lista 09: Generalização, classes abstratas e `final`

Projeto da disciplina de Programação Orientada a Objetos da FURB (Prof. André Felipe Bürger). Evolução do Sonora a partir da fase anterior (relacionamentos e coleções), incorporando também a hierarquia de conteúdo (lista 08) e os planos de assinatura (lista 09).

## O que mudou

### Hierarquia de conteúdo (lista 08 + 09)
- `Conteudo` (**abstrata**): `id` por contador estático (`setId` é `protected`), `titulo`, `duracaoSegundos`, `reproducoes` (só getter), `getCreditos()` **abstrato**, `reproduzir()` **final** (incrementa o contador e imprime `Reproduzindo: <título> - <créditos>`) e `toString()`.
- `Musica extends Conteudo`: `artista` e `album`; `getCreditos()` e `toString()` com `@Override` (`super.toString()` reaproveitado). O construtor antigo `Musica(titulo, artista, duracao)` foi mantido (sobrecarga) para nada quebrar.
- `Podcast extends Conteudo`: `apresentador` e `numeroEpisodio` (>= 1).

### Planos de assinatura (lista 09)
- **Rodada 1** — `Plano` (abstrata): `nome`, `maxDispositivos`, getters e `resumo()` (**final**). `temAnuncios()` e `calcularMensalidade()` ficaram **abstratos**, porque existem nos três planos, mas com algoritmo diferente em cada um.
- **Rodada 2** — `PlanoPago extends Plano` (abstrata): `precoMensal`, getter, `setPrecoMensal` com validação e `temAnuncios()` (igual nos dois planos pagos). Não implementa `calcularMensalidade()`.
- `PlanoGratuito` (**final**, herda de `Plano`), `PlanoIndividual` e `PlanoFamilia` (herdam de `PlanoPago`) implementam `calcularMensalidade()` com `@Override`.
- `PlanoIndividual` traz, no topo, o comentário da questão "Para pensar".

### Integração
- `Usuario` tem um `Plano` (começa no `PlanoGratuito`) e o método `assinar(Plano)`, que lança `IllegalArgumentException` para plano nulo.
- Menu do `App`: `11` trocar plano, `12` exibir resumo do plano, `13` demonstração de músicas e podcasts (toString, reproduções repetidas e contador). Entradas inválidas são tratadas com exceções; o menu não quebra.
- As linhas que provam as classes abstratas e a classe `final` estão comentadas em `demonstrarConteudos()` do `App`, cada uma com o erro de compilação e o motivo.

## Diagrama de classes
[`docs/diagrama-classes.png`](docs/diagrama-classes.png). Mostra a hierarquia dos planos e de conteúdo, classes/métodos abstratos em itálico, `{leaf}` para `final` e a associação `Usuario → Plano` com papel, nome, multiplicidade e navegabilidade.

Associação **Usuario → Plano** ("assina"): papéis `assinantes` (0..*) e `plano` (1); navegabilidade unidirecional, pois só `Usuario` guarda a referência.

## Como compilar e executar
```bash
mkdir -p out
javac -d out src/*.java
java -cp out App
```

## Como executar os testes
No IntelliJ, basta executar a pasta `test` (o JUnit é baixado pelo IDE). Pela linha de comando, baixe o `junit-platform-console-standalone-6.0.0.jar` para `lib/` (o `.jar` não é versionado, por causa do `.gitignore`):

```bash
javac -cp "lib/junit-platform-console-standalone-6.0.0.jar" -d out src/*.java test/*.java
java -jar lib/junit-platform-console-standalone-6.0.0.jar execute --class-path out --scan-class-path
```
Os testes das fases anteriores foram mantidos; `PlanoTest` e `ConteudoTest` cobrem a hierarquia, as validações, `abstract`/`final` e `Usuario.assinar`.

## Autor
Carlos Eduardo Mohr Barreto — FURB, Ciência da Computação.

# Sonora — Fase 03: Testes Unitários

## Contexto

Esta fase transforma os testes manuais do Sonora em testes automatizados com JUnit 5, cobrindo o comportamento definido na Fase 02 (validações e exceções).

## Planos de teste

### PL01 - Musica.getDuracaoFormatada()

| Caso | Descrição | Entrada | Saída esperada |
|---|---|---|---|
| 1 | Duração com minutos e segundos | Música "Fading Signal" de 125 segundos | Deve resultar em `"02:05"` |
| 2 | Duração redonda em minutos | Música "Night Frequency" de 90 segundos | Deve resultar em `"01:30"` |
| 3 | Menos de um minuto, com zero à esquerda | Música "Glass Horizon" de 5 segundos | Deve resultar em `"00:05"` |
| 4 | Dois dígitos nos minutos | Música "Static Bloom" de 600 segundos | Deve resultar em `"10:00"` |
| 5 | Valor logo abaixo de dez minutos | Música "Velvet Circuit" de 599 segundos | Deve resultar em `"09:59"` |

### PL02 - Validar construtor de Música com dados inválidos

| Caso | Descrição | Entrada | Saída esperada |
|---|---|---|---|
| 1 | Título vazio deve ser rejeitado | Título `""`, artista `"The Drift"`, duração `355` | Deve lançar `IllegalArgumentException` |
| 2 | Título nulo deve ser rejeitado | Título `null`, artista `"The Drift"`, duração `355` | Deve lançar `IllegalArgumentException` |
| 3 | Artista vazio deve ser rejeitado | Título `"Neon Tide"`, artista `""`, duração `355` | Deve lançar `IllegalArgumentException` |
| 4 | Duração zero deve ser rejeitada | Título `"Neon Tide"`, artista `"The Drift"`, duração `0` | Deve lançar `IllegalArgumentException` |
| 5 | Duração negativa deve ser rejeitada | Título `"Neon Tide"`, artista `"The Drift"`, duração `-10` | Deve lançar `IllegalArgumentException` |
| 6 | Dados válidos criam a música | Título `"Neon Tide"`, artista `"The Drift"`, duração `355` | Objeto criado, com ID maior que zero |

### PL03 - Playlist.adicionar(música)

| Caso | Descrição | Entrada | Saída esperada |
|---|---|---|---|
| 1 | Adicionar música em playlist vazia | Playlist nova + "Wandering Pulse" (Nova Wire) | Deve retornar `true` e a quantidade passar para `1` |
| 2 | Adicionar música em playlist com espaço | Playlist com "Wandering Pulse" + "Hollow Sky" (The Drift) | Deve retornar `true` e a quantidade aumentar em `1` |
| 3 | Tentar adicionar música com playlist cheia | Playlist com 100 músicas + "Faixa Extra" | Deve retornar `false` e a quantidade permanecer em `100` |

### PL04 - Playlist.getNaPosicao(indice)

| Caso | Descrição | Entrada | Saída esperada |
|---|---|---|---|
| 1 | Buscar música na primeira posição | Playlist com `"Wandering Pulse"` na posição `0` | Deve retornar a música `"Wandering Pulse"` |
| 2 | Buscar posição com índice negativo | Playlist com músicas + índice `-1` | Deve lançar `IndexOutOfBoundsException` |
| 3 | Buscar posição além da quantidade | Playlist com 2 músicas + índice `2` | Deve lançar `IndexOutOfBoundsException` |

### PL05 - Playlist.removerNaPosicao(indice)

| Caso | Descrição | Entrada | Saída esperada |
|---|---|---|---|
| 1 | Remover música de uma posição válida | Playlist `[Night Frequency, Glass Horizon, Static Bloom]`, remover posição `1` | Deve remover `"Glass Horizon"` e `"Static Bloom"` passar para a posição `1` |
| 2 | Remover a primeira música | Playlist `[Night Frequency, Glass Horizon, Static Bloom]`, remover posição `0` | Deve remover `"Night Frequency"` e `"Glass Horizon"` passar para a posição `0` |
| 3 | Remover usando índice negativo | Playlist com músicas + índice `-1` | Deve lançar `IndexOutOfBoundsException` |
| 4 | Remover usando índice além da quantidade | Playlist com 3 músicas + índice `3` | Deve lançar `IndexOutOfBoundsException` |

### PL06 - Plataforma.buscarMusica(título) e buscarMusicaPorId(id)

| Caso | Descrição | Entrada | Saída esperada |
|---|---|---|---|
| 1 | Buscar música cadastrada pelo título | Música `"Neon Tide"` cadastrada + título `"Neon Tide"` | Deve retornar a música cadastrada |
| 2 | Buscar música cadastrada pelo ID | Música cadastrada + ID correspondente | Deve retornar a música cadastrada |
| 3 | Buscar música por título inexistente | Título `"Musica Inexistente"` | Deve retornar `null` |
| 4 | Buscar música por ID inexistente | ID `-1` | Deve retornar `null` |

### PL07 - Musica.reproduzir()

| Caso | Descrição | Entrada | Saída esperada |
|---|---|---|---|
| 1 | Reproduzir música uma vez | "Silent Orbit" (Echo Valley) + chamada de `reproduzir()` | Contador deve passar para `1` |
| 2 | Reproduzir música duas vezes | "Silent Orbit" + duas chamadas de `reproduzir()` | Contador deve ser `2` |
| 3 | Reproduzir música várias vezes | "Silent Orbit" + cinco chamadas de `reproduzir()` | Contador deve ser `5` |

### PL08 - Bônus - Contadores de ID

| Caso | Descrição | Entrada | Saída esperada |
|---|---|---|---|
| 1 | IDs de músicas são sequenciais | Criar "Fading Signal", "Night Frequency" e "Glass Horizon" consecutivamente | Os IDs devem ser sequenciais |
| 2 | IDs de usuários são independentes dos IDs de músicas | Criar uma música e os usuários "Carlin" e "Ana" | O ID do usuário deve seguir seu próprio contador, independente do ID da música |
| 3 | Criar novas músicas após usuários | Criar músicas e usuários em sequência intercalada | Os IDs das músicas devem continuar sua sequência sem serem afetados pelos IDs dos usuários |

## Implementação

Cada linha das tabelas acima corresponde a um método `@Test` nas classes `MusicaTest`, `PlaylistTest` e `PlataformaTest`, com `@DisplayName` igual à coluna Descrição. Cenários repetidos (Usuario + Playlist, Plataforma com música cadastrada, Musica base para reprodução) são montados em `@BeforeEach`.
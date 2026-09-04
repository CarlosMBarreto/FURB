# 🎵 Sonora — Fase 02: Tratamento de Exceções

> Evolução da [Fase 01](../sonora-fase01) do projeto Sonora, com foco em deixar o sistema **robusto**: impedir que objetos nasçam em estado inválido, transformar parte da sinalização por retorno em lançamento de exceção, e blindar o menu contra digitação errada.

![Java](https://img.shields.io/badge/Java-POO-orange?logo=openjdk&logoColor=white)
![Status](https://img.shields.io/badge/status-conclu%C3%ADdo-brightgreen)
![Fase](https://img.shields.io/badge/fase-02-blueviolet)
![Exceções](https://img.shields.io/badge/tratamento-exce%C3%A7%C3%B5es-critical)

A Fase 01 permanece **congelada** em sua própria pasta; esta fase evolui as **mesmas classes**, sem quebrar o que já funcionava.

---

## 🔄 O que mudou em relação à Fase 01

| Antes (Fase 01) | Agora (Fase 02) |
|---|---|
| Objeto podia nascer em estado inválido | ❌ Construtores validam e lançam `IllegalArgumentException` |
| `getNaPosicao`/`removerNaPosicao` com índice inválido devolviam `null`/`false` | ⚠️ Lançam `IndexOutOfBoundsException` |
| Entrada de texto onde se esperava número derrubava o programa | 🛡️ Tratado com `try/catch`, o menu segue rodando |
| — | ✅ Pelo menos um bloco com **múltiplos `catch`** |
| — | ✅ Pelo menos um `finally` com propósito |

**O que continua igual (fluxo normal, não é erro):**
- `Playlist.adicionar` devolve `false` quando a playlist está cheia.
- `Plataforma.buscarMusicaPorId` e `buscarMusica` devolvem `null` quando não encontram.

---

## ✅ Validações por classe

**🎶 Musica**
- `titulo` e `artista`: não podem ser nulos, vazios ou só espaços
- `duracaoSegundos`: precisa ser maior que zero

**👤 Usuario**
- `nome`: não pode ser nulo/vazio
- `email`: não pode ser nulo/vazio e precisa conter `@`

**📃 Playlist**
- `nome`: não pode ser nulo/vazio
- `dono`: não pode ser nulo
- `adicionar(musica)`: lança exceção se `musica == null`, mas devolve `false` se a playlist estiver cheia

---

## ▶️ Como executar

```bash
# Compilar
javac *.java

# Executar
java App
```

---

## 🧪 Roteiro de demonstração

- [ ] **1.** Cadastrar música com título vazio → `IllegalArgumentException` tratada, programa continua vivo
- [ ] **2.** Cadastrar música com duração zero ou negativa → mesmo comportamento
- [ ] **3.** Cadastrar usuário com e-mail sem `@` → exceção tratada
- [ ] **4.** Pedir `getNaPosicao` de posição inexistente → `IndexOutOfBoundsException` (não mais `null`)
- [ ] **5.** Encher a playlist e tentar adicionar mais uma música → `adicionar` devolve `false` (continua retorno)
- [ ] **6.** Buscar música por id inexistente → continua devolvendo `null` (continua retorno)
- [ ] **7.** Digitar letra onde se espera número → programa avisa e pede de novo, sem cair
- [ ] **8.** Disparar bloco com múltiplos `catch`, provocando `NumberFormatException` e `IndexOutOfBoundsException`
- [ ] **9.** Mostrar o `finally` executando tanto em sucesso quanto em erro

---

## ✍️ Autor

**Carlos Eduardo Mohr Barreto** — FURB, Ciência da Computação.
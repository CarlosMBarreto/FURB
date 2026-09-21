# 🎵 Sonora — Fase 01

> Plataforma de streaming de música (estilo Spotify simplificado), desenvolvida como projeto da disciplina de **Programação Orientada a Objetos** — FURB.

![Java](https://img.shields.io/badge/Java-POO-orange?logo=openjdk&logoColor=white)
![Status](https://img.shields.io/badge/status-conclu%C3%ADdo-brightgreen)
![Fase](https://img.shields.io/badge/fase-01-blue)

---

## 📌 Sobre a fase

Esta é a primeira fase do projeto. O foco aqui é a **estrutura de classes**: modelagem, encapsulamento, construtores, sobrecarga de métodos e uso de arrays de tamanho fixo para armazenar dados.

### 🚫 Não fazem parte desta fase
- Coleções do `java.util` (`ArrayList`, `List`, `Map`, etc.) — tudo é armazenado em **arrays**.
- Herança ou interfaces.
- Tratamento de exceções *(fica para a [Fase 02](../sonora-fase02))*.

---

## 🧩 Classes

| Classe | Responsabilidade |
|---|---|
| 🎶 `Musica` | título, artista, duração, id automático e contador de reproduções |
| 👤 `Usuario` | nome, e-mail e id automático |
| 📃 `Playlist` | coleção de músicas de um usuário, com capacidade fixa |
| 🗄️ `Plataforma` | acervo de músicas e usuários cadastrados |
| 🖥️ `App` | menu interativo via console |

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

- [ ] Cadastrar uma música manualmente e conferir que recebe um id
- [ ] Cadastrar um usuário e conferir que recebe um id
- [ ] Criar uma playlist vinculada a um usuário cadastrado
- [ ] Adicionar músicas do acervo à playlist pelo id
- [ ] Buscar uma música por id
- [ ] Buscar uma música por título
- [ ] Reproduzir uma música e conferir o incremento do contador de reproduções
- [ ] Listar o acervo completo: músicas, usuários e playlists cadastrados

---

## ✍️ Autor

**Carlos Eduardo Mohr Barreto** — FURB, Ciência da Computação.
<div align="center">

# FURB | Ciência da Computação

Repositório acadêmico com exercícios, trabalhos e projetos desenvolvidos durante minha graduação em Ciência da Computação na Universidade Regional de Blumenau (FURB).

![Curso](https://img.shields.io/badge/Curso-Ci%C3%AAncia%20da%20Computa%C3%A7%C3%A3o-00599C?style=for-the-badge)
![Instituição](https://img.shields.io/badge/Institui%C3%A7%C3%A3o-FURB-007A33?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Em%20andamento-F7DF1E?style=for-the-badge)

</div>

## Sobre o repositório

Este repositório foi criado para reunir e organizar as atividades desenvolvidas ao longo do curso, registrando minha evolução acadêmica e a aplicação prática dos conteúdos estudados.

Aqui estão exercícios, trabalhos e projetos relacionados à programação, arquitetura de computadores, banco de dados, lógica e outros fundamentos da Ciência da Computação.

## Organização por semestre

### 1º semestre

| Disciplina | Principais conteúdos |
| --- | --- |
| **Arquitetura de Computadores I** | Sistemas de numeração, álgebra booleana, circuitos digitais, processadores, memória e dispositivos de entrada e saída |
| **Introdução à Programação** | Algoritmos, estruturas condicionais e de repetição, vetores, matrizes, métodos e introdução à orientação a objetos |
| **Introdução à Computação** | História da computação, sistemas operacionais, linguagens de programação, mercado de tecnologia e ética |
| **Fundamentos Matemáticos** | Teoria dos conjuntos, relações, funções, análise combinatória e fundamentos matemáticos aplicados à computação |

### 2º semestre — em andamento

| Disciplina | Principais conteúdos |
| --- | --- |
| **Programação Orientada a Objetos** | Classes, objetos, encapsulamento, herança, polimorfismo, interfaces, exceções e persistência |
| **Banco de Dados** | Modelagem de dados, modelo relacional, normalização, sistemas gerenciadores de banco de dados e linguagem SQL |
| **Arquitetura de Computadores II** | Linguagem Assembly, microprocessadores, barramentos, chipsets e comunicação com dispositivos de entrada e saída |
| **Lógica para Computação** | Lógica proposicional, lógica de predicados, dedução natural e formalização de problemas computacionais |

## Estrutura do repositório

```text
FURB/
├── BCC/
│   ├── Semestre1/
│   │   ├── ArquiteturaComputadores/   # trabalhos de numeração/conversão
│   │   ├── IntroducaoComputacao/
│   │   └── IntroducaoProgramacao/     # unit3 a unit7, provas e projeto final (Java)
│   └── Semestre2/
│       └── POO/
│           ├── Unit1/                 # listas 1 e 2, exemplos, Sonora Fase 1 e 2
│           ├── Unit2/                 # Sonora Fase 3 (testes JUnit)
│           └── Unit3/                 # Sonora Fase 5 (herança, classes abstratas e final)
└── .idea/                             # configuração do IntelliJ (módulos, JDK, JUnit)
```

## Projeto Sonora (POO)

Plataforma de streaming de música simplificada, evoluída fase a fase na disciplina de Programação Orientada a Objetos.

| Fase | Pasta | Foco |
| --- | --- | --- |
| 1 | `BCC/Semestre2/POO/Unit1/SonoraPhase1` | Estrutura de classes, vetores, encapsulamento e sobrecarga |
| 2 | `BCC/Semestre2/POO/Unit1/SonoraPhase2` | Validações e tratamento de exceções |
| 3 | `BCC/Semestre2/POO/Unit2/SonoraPhase3` | Planos de teste e testes automatizados com JUnit |
| 5 | `BCC/Semestre2/POO/Unit3/SonoraPhase5` | Diagrama UML, `ArrayList`, seguir usuários, hierarquia de conteúdo (`Conteudo`, `Musica`, `Podcast`) e planos de assinatura (classes abstratas e `final`) |

## Como abrir no IntelliJ IDEA

Abra a pasta raiz do repositório. Cada projeto é um módulo em `.idea/modules/`, com sua própria raiz de código, porque vários exercícios usam nomes de classe repetidos (`App`, `Main`, `Pessoa`...). Os módulos com testes (Fases 3 e 5) usam o JUnit 5 que o próprio IntelliJ baixa do Maven na primeira abertura.

## Tecnologias e ferramentas

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)

## Objetivos

- Organizar as atividades acadêmicas por semestre e disciplina;
- Registrar minha evolução durante a graduação;
- Praticar versionamento de código com Git e GitHub;
- Aplicar na prática os conhecimentos adquiridos em sala de aula;
- Construir um portfólio acadêmico de projetos e exercícios.

## Observação

Os códigos deste repositório possuem finalidade acadêmica e representam meu processo de aprendizado. Algumas soluções podem ser revisadas e aprimoradas conforme avanço no curso.

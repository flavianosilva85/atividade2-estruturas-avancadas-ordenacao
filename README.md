# Unyleya - Análise e Desenvolvimento de Sistemas
## Disciplina: Algoritmos e Estrutura de Dados (2º Período)
### Unidade 2 – Estruturas Avançadas e Ordenação | Atividade 2

---

## 👨‍💻 Identificação do Aluno
- **Aluno:** Flaviano Silva
- **Curso:** Análise e Desenvolvimento de Sistemas
- **Disciplina:** Algoritmos e Estrutura de Dados
- **Atividade:** Tarefa 2 (Unidade 2)
- **Linguagem:** Java (JDK 8 ou superior)

---

## 📋 Resumo dos Exercícios Desenvolvidos

Abaixo está o resumo dos 10 exercícios implementados com as estruturas de dados e algoritmos correspondentes:

| Exercício | Arquivo(s) | Estrutura / Conceito | Descrição da Solução |
| :--- | :--- | :--- | :--- |
| **Ex. 1** | `Exercicio01_InversaoLista.java` | Listas (`ArrayList`) | Inversão manual de lista de tarefas (dois ponteiros, in-place) sem métodos prontos da linguagem. |
| **Ex. 2** | `Exercicio02_RemocaoDuplicados.java` | Listas (`ArrayList`) | Algoritmo in-place para remoção de contatos duplicados em cadastro de usuários. |
| **Ex. 3** | `Exercicio03_MesclarListas.java` | Listas (`ArrayList`) | Mesclagem e intercalação alternada de duas listas de convidados com tamanhos dinâmicos. |
| **Ex. 4** | `Exercicio04_VerificacaoExpressoes.java` | Pilhas (`Stack`) | Validador sintático de parênteses balanceados em expressões matemáticas com pilha (LIFO). |
| **Ex. 5** | `Exercicio05_InversaoComPilha.java` | Pilhas (`Stack`) | Inversão da ordem de inserção de lista de produtos utilizando a propriedade LIFO da pilha. |
| **Ex. 6** | `Exercicio06_FilaEsperaClinica.java` | Filas (`Queue` / `LinkedList`) | Sistema interativo de fila de espera em clínica médica respeitando atendimento FIFO. |
| **Ex. 7** | `Exercicio07_OrdemChegadaLoja.java` | Filas (`Queue`) | Simulação de fluxo promocional em loja comparando ordem de chegada e saída por fila. |
| **Ex. 8** | `Exercicio08_ContagemPalavras.java` | Maps (`HashMap`) | Análise e contagem de frequência de palavras em texto com destaque para os termos mais comuns. |
| **Ex. 9** | `Exercicio09_MesclarMapas.java` | Maps (`HashMap`) | Consolidação de estoques de filiais mesclando mapas com resolução de conflito de chaves (soma). |
| **Ex. 10** | `Exercicio10_OrdenacaoVendas.java`<br>`ProdutoVenda.java` | Algoritmos de Ordenação | Implementação do algoritmo Bubble Sort para ordenar produtos por vendas em ordem decrescente. |

---

## 🛠️ Detalhamento dos Conceitos Implementados

### 1. Inversão de Lista (`Exercicio01_InversaoLista.java`)
- **Conceito:** Técnica dos dois ponteiros (`inicio` e `fim`) com troca direta de referências (`lista.set()`). O algoritmo realiza $O(n/2)$ trocas, sem alocar memória extra, atendendo à proibição de métodos prontos como `Collections.reverse()`.

### 2. Remoção de Elementos Duplicados (`Exercicio02_RemocaoDuplicados.java`)
- **Conceito:** Varredura bidirecional aninhada para detectar duplicidades em `ArrayList`. A cada duplicata identificada, o elemento posterior é removido com `.remove(j)` e o índice é retrocedido para compensar o shift à esquerda dos elementos.

### 3. Mesclagem Intercalada (`Exercicio03_MesclarListas.java`)
- **Conceito:** Intercalação alternada (Round-Robin/Zip) de duas coleções de convidados. A função trata automaticamente listas de tamanhos desiguais adicionando os excedentes ao final.

### 4. Verificação de Parênteses com Pilha (`Exercicio04_VerificacaoExpressoes.java`)
- **Conceito:** Estrutura de dados `Stack<Character>` operando em modo LIFO (Last-In, First-Out). Cada `(` é empilhado (`push`), e cada `)` exige desempilhar (`pop`). Identifica tanto desbalanceamento por excesso de fechamentos quanto aberturas órfãs.

### 5. Inversão com Pilha (`Exercicio05_InversaoComPilha.java`)
- **Conceito:** Demonstração prática do princípio LIFO: os elementos são inseridos em uma `Stack` e, ao serem desempilhados, saem exatamente na ordem inversa da inserção original.

### 6. Sistema de Fila Clínica (`Exercicio06_FilaEsperaClinica.java`)
- **Conceito:** Implementação da interface `Queue` com `LinkedList`, operando em FIFO (First-In, First-Out) com as primitivas `offer()` (adicionar ao final), `poll()` (atender e remover do início) e `peek()` (consultar próximo).

### 7. Ordem de Chegada e Saída (`Exercicio07_OrdemChegadaLoja.java`)
- **Conceito:** Controle de fluxo em fila. Demonstra com relatório tabular que a ordem de chegada na fila é identicamente mapeada para a ordem de saída dos caixas durante uma promoção.

### 8. Contagem de Frequência de Palavras (`Exercicio08_ContagemPalavras.java`)
- **Conceito:** Estrutura associativa `HashMap<String, Integer>`. O texto é sanitizado por expressão regular e as palavras são indexadas como chaves de acesso em tempo médio $O(1)$.

### 9. Mesclagem de Mapas com Tratamento de Conflito (`Exercicio09_MesclarMapas.java`)
- **Conceito:** Mesclagem de dicionários/tabelas hash. Quando a chave já existe no inventário consolidado, o algoritmo detecta a colisão semântica e agrega a quantidade ao invés de sobrescrever o valor anterior.

### 10. Algoritmo de Ordenação Decrescente (`Exercicio10_OrdenacaoVendas.java`)
- **Conceito:** Implementação do **Bubble Sort** decrescente com otimização por flag booleana (`houveTroca`). Permite posicionar os produtos mais vendidos no topo do ranking do e-commerce com complexidade espacial $O(1)$ in-place.

---

## 🚀 Como Compilar e Executar

Execute no terminal (CMD / PowerShell) dentro da pasta da Atividade 2:

```bash
# Compilar todos os códigos Java da pasta:
javac *.java

# Executar cada exercício:
java Exercicio01_InversaoLista
java Exercicio02_RemocaoDuplicados
java Exercicio03_MesclarListas
java Exercicio04_VerificacaoExpressoes
java Exercicio05_InversaoComPilha
java Exercicio06_FilaEsperaClinica
java Exercicio07_OrdemChegadaLoja
java Exercicio08_ContagemPalavras
java Exercicio09_MesclarMapas
java Exercicio10_OrdenacaoVendas
```

---

## 📦 Entrega
Os arquivos estão prontos para submissão no portal da Unyleya via arquivo compactado `.zip` ou através do repositório no GitHub.

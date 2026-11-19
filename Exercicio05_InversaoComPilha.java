import java.util.ArrayList;
import java.util.Stack;

/**
 * Curso: Análise e Desenvolvimento de Sistemas
 * Disciplina: Algoritmos e Estrutura de Dados
 * Unidade 2 - Atividade 2
 * 
 * Exercício 5: Inversão de Lista com Pilha (Stack)
 * 
 * Enunciado:
 * Suponha que você está desenvolvendo uma ferramenta que permite ao usuário
 * visualizar uma lista de produtos na ordem inversa da inserção original.
 * Implemente um método que utilize uma pilha para inverter a ordem dos
 * elementos de uma lista de produtos (ArrayList).
 */
public class Exercicio05_InversaoComPilha {

    public static void main(String[] args) {
        ArrayList<String> produtos = new ArrayList<String>();

        // Inserção sequencial na ordem de cadastro original
        produtos.add("1. Smartphone Galaxy S24");
        produtos.add("2. Notebook Dell Inspiron 15");
        produtos.add("3. Fone Bluetooth Noise Cancelling");
        produtos.add("4. Smartwatch Pro Series");
        produtos.add("5. Monitor Ultrawide 29 Polegadas");

        System.out.println("==================================================");
        System.out.println("    INVERSÃO DE PRODUTOS UTILIZANDO PILHA (LIFO)  ");
        System.out.println("==================================================");

        System.out.println("\n[PRODUTOS NA ORDEM ORIGINAL DE INSERÇÃO]:");
        exibirLista(produtos);

        // Aplicação da inversão via Pilha
        inverterComPilha(produtos);

        System.out.println("\n--------------------------------------------------");
        System.out.println("[PRODUTOS NA ORDEM INVERSA (Últimos Inseridos Primeiro)]:");
        exibirLista(produtos);
        System.out.println("==================================================");
    }

    /**
     * Inverte os elementos de um ArrayList utilizando o princípio LIFO
     * (Last-In, First-Out) característico da estrutura de dados Pilha (Stack).
     * 
     * Passos:
     * 1. Empilha (push) todos os elementos da lista na pilha.
     * 2. Limpa a lista original.
     * 3. Desempilha (pop) cada item de volta para a lista, invertendo
     *    naturalmente a ordem original.
     * 
     * Complexidade de Tempo: O(N)
     * Complexidade de Espaço: O(N)
     * 
     * @param lista Lista de produtos a ser invertida
     */
    public static void inverterComPilha(ArrayList<String> lista) {
        Stack<String> pilha = new Stack<String>();

        // Fase 1: Empilhar todos os itens
        for (String item : lista) {
            pilha.push(item);
        }

        // Fase 2: Esvaziar a lista para receber os itens na nova ordem
        lista.clear();

        // Fase 3: Desempilhar (o último elemento a entrar será o primeiro a sair)
        while (!pilha.isEmpty()) {
            lista.add(pilha.pop());
        }
    }

    /**
     * Imprime a lista no console.
     */
    public static void exibirLista(ArrayList<String> lista) {
        for (String item : lista) {
            System.out.println(" - " + item);
        }
    }
}

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Curso: Análise e Desenvolvimento de Sistemas
 * Disciplina: Algoritmos e Estrutura de Dados
 * Unidade 2 - Atividade 2
 * 
 * Exercício 1: Inversão de Lista de Tarefas (ArrayList)
 * 
 * Enunciado:
 * Imagine que você está desenvolvendo um recurso em um aplicativo que exibe uma
 * lista de tarefas do dia em ordem inversa. Escreva um programa que inverta os
 * elementos de uma lista de tarefas (ArrayList) sem utilizar métodos prontos da linguagem,
 * dando ao usuário a opção de ver a lista do fim para o começo.
 */
public class Exercicio01_InversaoLista {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> listaTarefas = new ArrayList<String>();

        // Tarefas padrão de exemplo
        listaTarefas.add("1. Responder e-mails da equipe");
        listaTarefas.add("2. Participar da reunião de Daily Scrum");
        listaTarefas.add("3. Implementar módulo de autenticação");
        listaTarefas.add("4. Revisar Pull Requests no GitHub");
        listaTarefas.add("5. Realizar testes de integração");

        System.out.println("==================================================");
        System.out.println("       GERENCIADOR DE TAREFAS - INVERSÃO          ");
        System.out.println("==================================================");

        System.out.println("\n[LISTA ORIGINAL DE TAREFAS (Ordem Cronológica)]:");
        exibirLista(listaTarefas);

        System.out.print("\nDeseja inverter a visualização das tarefas? (s/n): ");
        String resposta = scanner.nextLine().trim().toLowerCase();

        if (resposta.equals("s")) {
            // Chamada do método algorítmico manual de inversão (in-place)
            inverterListaManual(listaTarefas);

            System.out.println("\n[LISTA INVERTIDA (Do fim para o começo)]:");
            exibirLista(listaTarefas);
            System.out.println("\n>> Lista invertida com sucesso utilizando o algoritmo de dois ponteiros!");
        } else {
            System.out.println("\nOperação cancelada. A lista permaneceu na ordem original.");
        }

        System.out.println("==================================================");
        scanner.close();
    }

    /**
     * Inverte os elementos de um ArrayList in-place sem recorrer a métodos
     * utilitários prontos como Collections.reverse().
     * 
     * Complexidade de Tempo: O(n/2) -> O(n)
     * Complexidade de Espaço: O(1)
     * 
     * @param lista Lista a ser invertida
     */
    public static void inverterListaManual(ArrayList<String> lista) {
        int inicio = 0;
        int fim = lista.size() - 1;

        while (inicio < fim) {
            // Troca manual dos elementos (swap)
            String temp = lista.get(inicio);
            lista.set(inicio, lista.get(fim));
            lista.set(fim, temp);

            inicio++;
            fim--;
        }
    }

    /**
     * Exibe os itens da lista numerados.
     */
    public static void exibirLista(ArrayList<String> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(" - " + lista.get(i));
        }
    }
}

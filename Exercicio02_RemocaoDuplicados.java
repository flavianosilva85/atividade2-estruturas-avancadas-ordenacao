import java.util.ArrayList;

/**
 * Curso: Análise e Desenvolvimento de Sistemas
 * Disciplina: Algoritmos e Estrutura de Dados
 * Unidade 2 - Atividade 2
 * 
 * Exercício 2: Remoção de Elementos Duplicados em ArrayList
 * 
 * Enunciado:
 * Em um sistema de cadastro, é comum que contatos sejam adicionados mais de uma vez.
 * Crie um método que remova contatos duplicados de uma lista de usuários (ArrayList),
 * deixando apenas uma entrada por pessoa e otimizando o banco de dados.
 */
public class Exercicio02_RemocaoDuplicados {

    public static void main(String[] args) {
        ArrayList<String> contatos = new ArrayList<String>();

        // Inserção intencional de registros duplicados para simulação
        contatos.add("Carlos Eduardo - carlos@email.com");
        contatos.add("Mariana Souza - mariana@email.com");
        contatos.add("Carlos Eduardo - carlos@email.com"); // Duplicado
        contatos.add("Beatriz Lima - beatriz@email.com");
        contatos.add("Mariana Souza - mariana@email.com"); // Duplicado
        contatos.add("Rafael Gomes - rafael@email.com");
        contatos.add("Carlos Eduardo - carlos@email.com"); // Triplicado

        System.out.println("==================================================");
        System.out.println("     SISTEMA DE CADASTRO: DEDUPLICAÇÃO DE CONTATOS");
        System.out.println("==================================================");

        System.out.println("\n[LISTA ORIGINAL DE CONTATOS (Total: " + contatos.size() + " registros)]:");
        exibirLista(contatos);

        // Execução do algoritmo de remoção in-place
        int duplicadosRemovidos = removerContatosDuplicados(contatos);

        System.out.println("\n--------------------------------------------------");
        System.out.println(">> Total de registros duplicados removidos: " + duplicadosRemovidos);
        System.out.println("--------------------------------------------------");

        System.out.println("\n[LISTA OTIMIZADA DE CONTATOS (Total: " + contatos.size() + " registros)]:");
        exibirLista(contatos);
        System.out.println("==================================================");
    }

    /**
     * Remove contatos duplicados diretamente no ArrayList original (in-place),
     * preservando a primeira ocorrência de cada contato.
     * 
     * Algoritmo:
     * Para cada índice i, percorre os índices j posteriores.
     * Se encontrar valor idêntico, remove a posição j e decrementa j para
     * compensar o deslocamento dos elementos subsequentes no ArrayList.
     * 
     * @param lista A lista de contatos a ser limpa
     * @return Quantidade de itens duplicados removidos
     */
    public static int removerContatosDuplicados(ArrayList<String> lista) {
        int contadorRemocoes = 0;

        for (int i = 0; i < lista.size(); i++) {
            String contatoAtual = lista.get(i);

            for (int j = i + 1; j < lista.size(); j++) {
                if (contatoAtual.equalsIgnoreCase(lista.get(j))) {
                    lista.remove(j);
                    j--; // Decrementa para não pular o próximo item deslocado à esquerda
                    contadorRemocoes++;
                }
            }
        }

        return contadorRemocoes;
    }

    /**
     * Imprime os contatos formatados.
     */
    public static void exibirLista(ArrayList<String> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + ". " + lista.get(i));
        }
    }
}

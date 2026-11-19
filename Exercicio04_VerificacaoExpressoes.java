import java.util.Scanner;
import java.util.Stack;

/**
 * Curso: Análise e Desenvolvimento de Sistemas
 * Disciplina: Algoritmos e Estrutura de Dados
 * Unidade 2 - Atividade 2
 * 
 * Exercício 4: Verificação de Expressões Matemáticas com Pilha
 * 
 * Enunciado:
 * No desenvolvimento de uma calculadora, você precisa verificar se a expressão
 * matemática digitada está com os parênteses corretamente balanceados. Utilize uma
 * pilha para desenvolver um programa que verifique essa estrutura, ajudando a
 * identificar possíveis erros antes do cálculo.
 */
public class Exercicio04_VerificacaoExpressoes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println("   CALCULADORA: VALIDADOR DE PARÊNTESES COM PILHA ");
        System.out.println("==================================================");

        // Bateria de testes demonstrativos
        String[] expressoesExemplo = {
            "(2 + 3) * (5 - 1)",
            "((10 + 5) / 3) * (2 + 4)",
            "((2 * 3) + 5",          // Erro: falta fechar um parêntese
            ") 5 + 3 ( * 2",         // Erro: fecha antes de abrir
            "(a + b) * (c - (d + e))"
        };

        System.out.println("\n[TESTES AUTOMÁTICOS COM EXPRESSÕES PRÉ-DEFINIDAS]:");
        for (String exp : expressoesExemplo) {
            boolean valida = verificarParentesesBalanceados(exp);
            System.out.println("Expressão : \"" + exp + "\"");
            System.out.println("Resultado : " + (valida ? "VÁLIDA (Balanceada)" : "INVÁLIDA (Desbalanceada)") + "\n");
        }

        System.out.println("--------------------------------------------------");
        System.out.println("Agora teste com a sua própria expressão:");
        System.out.print("Digite uma expressão matemática: ");
        String expressaoUsuario = scanner.nextLine();

        if (verificarParentesesBalanceados(expressaoUsuario)) {
            System.out.println("\n>> SUCESSO: A expressão possui todos os parênteses corretamente balanceados!");
        } else {
            System.out.println("\n>> ERRO DE SINTAXE: Parênteses incorretos ou desbalanceados!");
        }

        System.out.println("==================================================");
        scanner.close();
    }

    /**
     * Verifica se os parênteses em uma expressão matemática estão balanceados
     * utilizando o conceito LIFO (Last-In, First-Out) de uma Pilha.
     * 
     * Regras:
     * 1. Ao encontrar '(', empilha na estrutura.
     * 2. Ao encontrar ')', verifica se há correspondente no topo desempilhando.
     *    Se a pilha estiver vazia, houve fechamento prematuro (erro).
     * 3. Ao final da leitura, a pilha DEVE estar vazia. Se contiver elementos,
     *    faltaram parênteses de fechamento.
     * 
     * @param expressao String contendo a expressão matemática
     * @return true se a expressão for balanceada; false caso contrário
     */
    public static boolean verificarParentesesBalanceados(String expressao) {
        Stack<Character> pilha = new Stack<Character>();

        for (int i = 0; i < expressao.length(); i++) {
            char c = expressao.charAt(i);

            if (c == '(') {
                pilha.push(c); // Empilha abertura
            } else if (c == ')') {
                if (pilha.isEmpty()) {
                    return false; // Tentou fechar sem haver abertura aberta correspondente
                }
                pilha.pop(); // Desempilha o par correspondente
            }
        }

        // Se a pilha estiver vazia ao final, todos os pares foram satisfeitos
        return pilha.isEmpty();
    }
}

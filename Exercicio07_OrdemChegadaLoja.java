import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Curso: Análise e Desenvolvimento de Sistemas
 * Disciplina: Algoritmos e Estrutura de Dados
 * Unidade 2 - Atividade 2
 * 
 * Exercício 7: Ordem de Chegada e Saída no Fluxo de Clientes (FIFO)
 * 
 * Enunciado:
 * Imagine que você está organizando o fluxo de clientes em uma loja durante
 * uma promoção. Crie um programa que simule a ordem de chegada e exiba
 * a ordem de saída, respeitando a fila de atendimento.
 */
public class Exercicio07_OrdemChegadaLoja {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("  MEGA PROMOÇÃO - SIMULADOR DE FLUXO DE CLIENTES  ");
        System.out.println("==================================================");

        // Fila que controla a ordem de atendimento (FIFO)
        Queue<String> filaLoja = new LinkedList<String>();

        // Listas auxiliares para registrar e comparar chegada e saída
        ArrayList<String> registroChegada = new ArrayList<String>();
        ArrayList<String> registroSaida = new ArrayList<String>();

        // Simulação da Fase 1: Chegada dos clientes na loja durante a promoção
        String[] clientesChegando = {
            "Cliente 101 - Fernanda Costa",
            "Cliente 102 - Bruno Mendonça",
            "Cliente 103 - Camila Albuquerque",
            "Cliente 104 - Diego Silveira",
            "Cliente 105 - Eliane Duarte"
        };

        System.out.println("\n--- FASE 1: REGISTRO DA ORDEM DE CHEGADA NA LOJA ---");
        for (String cliente : clientesChegando) {
            filaLoja.offer(cliente);         // Enfileira
            registroChegada.add(cliente);    // Registra histórico
            System.out.println(" [CHEGADA] " + cliente + " entrou na fila.");
        }

        System.out.println("\nFila formada com " + filaLoja.size() + " clientes aguardando atendimento nos caixas.\n");

        // Simulação da Fase 2: Atendimento no caixa e liberação de saída
        System.out.println("--- FASE 2: ATENDIMENTO NO CAIXA E ORDEM DE SAÍDA ---");
        int ordem = 1;
        while (!filaLoja.isEmpty()) {
            String atendido = filaLoja.poll(); // Desinfileira (Primeiro que chegou é o primeiro que sai)
            registroSaida.add(atendido);
            System.out.println(" [SAÍDA " + ordem + "] " + atendido + " realizou o pagamento e liberou o caixa.");
            ordem++;
        }

        // Exibição comparativa do fluxo
        System.out.println("\n==================================================================");
        System.out.println("             RELATÓRIO COMPARATIVO: CHEGADA VS SAÍDA              ");
        System.out.println("==================================================================");
        System.out.println(String.format("%-5s | %-30s | %-30s", "Pos", "Ordem de Chegada", "Ordem de Saída"));
        System.out.println("------------------------------------------------------------------");

        for (int i = 0; i < registroChegada.size(); i++) {
            System.out.println(String.format("%02dº   | %-30s | %-30s",
                    (i + 1),
                    registroChegada.get(i),
                    registroSaida.get(i)));
        }

        System.out.println("==================================================================");
        System.out.println("Conclusão: Princípio FIFO (First-In, First-Out) estritamente respeitado!");
        System.out.println("Nenhum cliente teve sua prioridade desrespeitada durante a promoção.");
        System.out.println("==================================================================");
    }
}

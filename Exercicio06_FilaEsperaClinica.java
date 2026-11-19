import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Curso: Análise e Desenvolvimento de Sistemas
 * Disciplina: Algoritmos e Estrutura de Dados
 * Unidade 2 - Atividade 2
 * 
 * Exercício 6: Implementação de Sistema de Fila de Espera em Clínica (FIFO)
 * 
 * Enunciado:
 * Em uma clínica, os pacientes aguardam atendimento em uma fila de espera.
 * Crie um sistema que simule essa fila, permitindo adicionar, remover e exibir
 * a ordem de atendimento dos pacientes. Isso ajudará na organização e no controle
 * da ordem de atendimento.
 */
public class Exercicio06_FilaEsperaClinica {

    // Estrutura de Fila (FIFO - First-In, First-Out) implementada com LinkedList
    private static Queue<String> filaPacientes = new LinkedList<String>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pacientes iniciais para demonstração prática
        filaPacientes.offer("Maria Aparecida Santos (Senha 01)");
        filaPacientes.offer("José Roberto de Oliveira (Senha 02)");
        filaPacientes.offer("Ana Paula Ferreira (Senha 03)");

        System.out.println("==================================================");
        System.out.println("     CLÍNICA VIDA & SAÚDE - FILA DE ESPERA (FIFO) ");
        System.out.println("==================================================");

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n--- PAINEL DE ATENDIMENTO ---");
            System.out.println("1 - Adicionar paciente à fila (Enqueue)");
            System.out.println("2 - Chamar próximo paciente para consulta (Dequeue)");
            System.out.println("3 - Consultar próximo paciente (Peek)");
            System.out.println("4 - Exibir ordem completa da fila");
            System.out.println("0 - Encerrar sistema");
            System.out.print("Escolha uma opção: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Opção inválida! Digite um número do menu.");
                scanner.nextLine();
                continue;
            }

            opcao = scanner.nextInt();
            scanner.nextLine(); // Consome o \n

            switch (opcao) {
                case 1:
                    System.out.print("\nNome do paciente a ser cadastrado na fila: ");
                    String nome = scanner.nextLine().trim();
                    if (!nome.isEmpty()) {
                        filaPacientes.offer(nome);
                        System.out.println(">> Paciente \"" + nome + "\" adicionado à fila com sucesso!");
                    } else {
                        System.out.println(">> Nome inválido! Nenhum registro adicionado.");
                    }
                    exibirFila();
                    break;

                case 2:
                    if (!filaPacientes.isEmpty()) {
                        String pacienteAtendido = filaPacientes.poll(); // Remove o primeiro da fila (FIFO)
                        System.out.println("\n>> ATENÇÃO: Chamando paciente para a sala médica: [" + pacienteAtendido + "]");
                    } else {
                        System.out.println("\n>> A fila de espera está vazia! Não há pacientes para atender.");
                    }
                    exibirFila();
                    break;

                case 3:
                    if (!filaPacientes.isEmpty()) {
                        System.out.println("\n>> PRÓXIMO DA FILA: " + filaPacientes.peek());
                    } else {
                        System.out.println("\n>> A fila de espera está vazia.");
                    }
                    break;

                case 4:
                    exibirFila();
                    break;

                case 0:
                    System.out.println("\nEncerrando o sistema de atendimento da clínica. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }

    /**
     * Exibe a relação ordenada dos pacientes na fila.
     */
    private static void exibirFila() {
        System.out.println("\n----------------- SITUAÇÃO DA FILA DE ESPERA -----------------");
        if (filaPacientes.isEmpty()) {
            System.out.println("Nenhum paciente aguardando no momento.");
        } else {
            int posicao = 1;
            for (String paciente : filaPacientes) {
                System.out.println(posicao + "º Lugar: " + paciente);
                posicao++;
            }
        }
        System.out.println("Total de pacientes na fila: " + filaPacientes.size());
        System.out.println("--------------------------------------------------------------");
    }
}

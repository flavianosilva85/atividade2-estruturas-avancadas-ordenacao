import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Curso: Análise e Desenvolvimento de Sistemas
 * Disciplina: Algoritmos e Estrutura de Dados
 * Unidade 2 - Atividade 2
 * 
 * Exercício 8: Análise de Frequência de Palavras com HashMap
 * 
 * Enunciado:
 * Você precisa criar uma análise de palavras usadas em um artigo para entender
 * quais termos aparecem com maior frequência. Escreva um programa que conte a
 * frequência de cada palavra em uma frase, utilizando um HashMap, para identificar
 * as palavras mais comuns.
 */
public class Exercicio08_ContagemPalavras {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println("       ANÁLISE DE FREQUÊNCIA DE PALAVRAS (HASHMAP)");
        System.out.println("==================================================");

        System.out.println("Digite a frase ou parágrafo do artigo a ser analisado:");
        System.out.println("(Pressione ENTER direto para usar o texto padrão sobre tecnologia)");
        System.out.print("> ");
        String texto = scanner.nextLine().trim();

        if (texto.isEmpty()) {
            texto = "A inteligência artificial e a ciência de dados transformam a tecnologia. "
                  + "Com inteligência e dados, a tomada de decisão fica mais precisa e a inovação cresce.";
            System.out.println("\n[TEXTO PADRÃO CARREGADO]:\n\"" + texto + "\"");
        }

        // Limpeza e normalização do texto (remove pontuações e converte para minúsculas)
        String textoLimpo = texto.toLowerCase().replaceAll("[^a-záàâãéèêíïóôõöúç0-9\\s]", "");
        String[] palavras = textoLimpo.split("\\s+");

        // HashMap para armazenar a contagem: Palavra (Chave) -> Ocorrências (Valor)
        Map<String, Integer> mapaFrequencia = new HashMap<String, Integer>();

        for (String palavra : palavras) {
            if (!palavra.isEmpty()) {
                if (mapaFrequencia.containsKey(palavra)) {
                    mapaFrequencia.put(palavra, mapaFrequencia.get(palavra) + 1);
                } else {
                    mapaFrequencia.put(palavra, 1);
                }
            }
        }

        // Identifica a maior frequência registrada
        int maiorFrequencia = 0;
        for (int contagem : mapaFrequencia.values()) {
            if (contagem > maiorFrequencia) {
                maiorFrequencia = contagem;
            }
        }

        // Exibição do relatório analítico
        System.out.println("\n================ RELATÓRIO DE TERMOS IDENTIFICADOS ===============");
        System.out.println(String.format("%-25s | %-12s | %-15s", "Termo / Palavra", "Frequência", "Status"));
        System.out.println("------------------------------------------------------------------");

        for (Map.Entry<String, Integer> entrada : mapaFrequencia.entrySet()) {
            String status = (entrada.getValue() == maiorFrequencia) ? "⭐ MAIS FREQUENTE" : "";
            System.out.println(String.format("%-25s | %-12d | %s", entrada.getKey(), entrada.getValue(), status));
        }

        System.out.println("------------------------------------------------------------------");
        System.out.println("Total de palavras analisadas : " + palavras.length);
        System.out.println("Total de termos únicos (keys): " + mapaFrequencia.size());
        System.out.println("Maior contagem registrada     : " + maiorFrequencia + " ocorrência(s)");
        System.out.println("==================================================================");

        scanner.close();
    }
}

import java.util.HashMap;
import java.util.Map;

/**
 * Curso: Análise e Desenvolvimento de Sistemas
 * Disciplina: Algoritmos e Estrutura de Dados
 * Unidade 2 - Atividade 2
 * 
 * Exercício 9: Mesclar Mapas com Tratamento de Conflito de Chaves
 * 
 * Enunciado:
 * Em um sistema de inventário, você tem dois registros de produtos e deseja mesclar
 * as informações. Implemente um método para mesclar dois mapas (HashMaps) de produtos,
 * cuidando para tratar possíveis conflitos de chaves.
 */
public class Exercicio09_MesclarMapas {

    public static void main(String[] args) {
        // Registro de estoque da Filial A (Centro)
        Map<String, Integer> estoqueFilialA = new HashMap<String, Integer>();
        estoqueFilialA.put("Notebook Gamer i7", 10);
        estoqueFilialA.put("Teclado Mecânico RGB", 25); // Conflito com Filial B
        estoqueFilialA.put("Mouse Óptico Sem Fio", 40);  // Conflito com Filial B
        estoqueFilialA.put("Cabo HDMI 2.1 Ultra", 50);

        // Registro de estoque da Filial B (Shopping)
        Map<String, Integer> estoqueFilialB = new HashMap<String, Integer>();
        estoqueFilialB.put("Teclado Mecânico RGB", 15); // Conflito com Filial A
        estoqueFilialB.put("Mouse Óptico Sem Fio", 20);  // Conflito com Filial A
        estoqueFilialB.put("Monitor Curvo 27 Pol", 8);
        estoqueFilialB.put("Headset 7.1 Surround", 18);

        System.out.println("==================================================");
        System.out.println("     SISTEMA DE INVENTÁRIO: MESCLAGEM DE MAPAS    ");
        System.out.println("==================================================");

        System.out.println("\n[INVENTÁRIO 1 - FILIAL CENTRO]:");
        exibirMapa(estoqueFilialA);

        System.out.println("\n[INVENTÁRIO 2 - FILIAL SHOPPING]:");
        exibirMapa(estoqueFilialB);

        // Execução do algoritmo de mesclagem com tratamento de conflito
        Map<String, Integer> estoqueConsolidado = mesclarMapasProdutos(estoqueFilialA, estoqueFilialB);

        System.out.println("\n================ INVENTÁRIO CONSOLIDADO FINAL ====================");
        System.out.println("Regra de Conflito: Chaves duplicadas têm suas quantidades somadas.");
        System.out.println("------------------------------------------------------------------");
        exibirMapa(estoqueConsolidado);
        System.out.println("==================================================================");
    }

    /**
     * Mescla dois HashMaps de produtos tratando conflitos de chave.
     * Caso um mesmo produto exista em ambos os mapas, suas quantidades
     * são somadas para refletir o saldo global do inventário.
     * 
     * Complexidade de Tempo: O(N + M)
     * 
     * @param mapa1 Primeiro mapa de estoque
     * @param mapa2 Segundo mapa de estoque
     * @return Novo HashMap com todos os produtos consolidados
     */
    public static Map<String, Integer> mesclarMapasProdutos(Map<String, Integer> mapa1, Map<String, Integer> mapa2) {
        Map<String, Integer> mapaResultado = new HashMap<String, Integer>();

        // 1. Adiciona todos os itens do primeiro mapa
        for (Map.Entry<String, Integer> item : mapa1.entrySet()) {
            mapaResultado.put(item.getKey(), item.getValue());
        }

        // 2. Itera sobre o segundo mapa tratando conflitos
        System.out.println("\n--- PROCESSAMENTO DE MESCLAGEM E CONFLITOS ---");
        for (Map.Entry<String, Integer> item : mapa2.entrySet()) {
            String chave = item.getKey();
            int quantidadeAdicional = item.getValue();

            if (mapaResultado.containsKey(chave)) {
                int quantidadeAnterior = mapaResultado.get(chave);
                int quantidadeTotal = quantidadeAnterior + quantidadeAdicional;
                mapaResultado.put(chave, quantidadeTotal);

                System.out.println("[CONFLITO RESOLVIDO] Produto: \"" + chave + "\"");
                System.out.println("  Estoque anterior: " + quantidadeAnterior + " + Novo: " 
                        + quantidadeAdicional + " = Total Consolidado: " + quantidadeTotal + " unidades.");
            } else {
                mapaResultado.put(chave, quantidadeAdicional);
                System.out.println("[NOVO ITEM INSERIDO] Produto: \"" + chave + "\" (" + quantidadeAdicional + " un).");
            }
        }

        return mapaResultado;
    }

    /**
     * Exibe o conteúdo de um mapa de inventário.
     */
    public static void exibirMapa(Map<String, Integer> mapa) {
        for (Map.Entry<String, Integer> entrada : mapa.entrySet()) {
            System.out.println(String.format(" - %-26s : %3d unidades em estoque",
                    entrada.getKey(), entrada.getValue()));
        }
    }
}

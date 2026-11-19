import java.util.ArrayList;

/**
 * Curso: Análise e Desenvolvimento de Sistemas
 * Disciplina: Algoritmos e Estrutura de Dados
 * Unidade 2 - Atividade 2
 * 
 * Exercício 10: Algoritmo de Ordenação para Ranking de Vendas (Decrescente)
 * 
 * Enunciado:
 * Imagine que você está desenvolvendo um sistema de classificação que exibe os
 * produtos mais populares em uma loja online. Escolha um algoritmo de ordenação
 * (ex: Bubble Sort, Quick Sort, Merge Sort) e implemente-o para ordenar uma lista
 * de produtos com base nas vendas, de forma decrescente, para que os mais vendidos
 * apareçam primeiro.
 */
public class Exercicio10_OrdenacaoVendas {

    public static void main(String[] args) {
        ArrayList<ProdutoVenda> produtos = new ArrayList<ProdutoVenda>();

        // Cadastro desordenado de produtos e volumes de venda
        produtos.add(new ProdutoVenda(101, "Mouse Gamer RGB 16000DPI", 1250, 149.90));
        produtos.add(new ProdutoVenda(102, "Teclado Mecânico Switch Blue", 890, 289.00));
        produtos.add(new ProdutoVenda(103, "Cadeira Gamer Ergonômica", 310, 899.90));
        produtos.add(new ProdutoVenda(104, "Headset Sem Fio Surround 7.1", 2150, 399.00));
        produtos.add(new ProdutoVenda(105, "Monitor Gamer 144Hz 1ms", 640, 1150.00));
        produtos.add(new ProdutoVenda(106, "Webcam Full HD 1080p 60fps", 1780, 229.50));
        produtos.add(new ProdutoVenda(107, "Mousepad Extra Grande 90x40", 3420, 59.90));

        System.out.println("======================================================================");
        System.out.println("      E-COMMERCE TECH: RANKING DE POPULARIDADE (MAIS VENDIDOS)        ");
        System.out.println("======================================================================");

        System.out.println("\n[LISTA DE PRODUTOS ANTES DA ORDENAÇÃO (Ordem de Entrada)]:");
        exibirProdutos(produtos);

        // Execução do algoritmo de ordenação Bubble Sort Decrescente
        ordenarPorVendasDecrescente(produtos);

        System.out.println("\n======================================================================");
        System.out.println("     RANKING OFICIAL: PRODUTOS MAIS POPULARES (ORDEM DECRESCENTE)     ");
        System.out.println("======================================================================");
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println(String.format("Top %02d -> %s", (i + 1), produtos.get(i)));
        }
        System.out.println("======================================================================");
    }

    /**
     * Ordena a lista de produtos com base nas vendas em ordem DECRESCENTE
     * utilizando o algoritmo Bubble Sort otimizado (com flag de troca).
     * 
     * Como funciona:
     * Compara elementos adjacentes. Se o produto da esquerda tiver MENOS vendas
     * que o produto da direita (produtos[j].vendas < produtos[j+1].vendas),
     * realiza a troca (swap), empurrando os produtos com mais vendas para
     * o topo da lista.
     * 
     * Complexidade de Tempo: O(N²) no pior caso, O(N) no melhor caso (já ordenado).
     * Complexidade de Espaço: O(1) in-place.
     * 
     * @param lista Lista de produtos a ser ordenada
     */
    public static void ordenarPorVendasDecrescente(ArrayList<ProdutoVenda> lista) {
        int n = lista.size();
        boolean houveTroca;

        for (int i = 0; i < n - 1; i++) {
            houveTroca = false;

            for (int j = 0; j < n - 1 - i; j++) {
                // Condição para ordem DECRESCENTE:
                // Se o elemento atual vendeu MENOS que o próximo, inverte as posições
                if (lista.get(j).getQuantidadeVendas() < lista.get(j + 1).getQuantidadeVendas()) {
                    ProdutoVenda temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                    houveTroca = true;
                }
            }

            // Otimização: se nenhuma troca ocorreu nesta passada, a lista já está ordenada
            if (!houveTroca) {
                break;
            }
        }
    }

    /**
     * Exibe a lista de produtos formatada.
     */
    public static void exibirProdutos(ArrayList<ProdutoVenda> lista) {
        for (ProdutoVenda p : lista) {
            System.out.println(" - " + p);
        }
    }
}

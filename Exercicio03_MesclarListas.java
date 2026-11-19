import java.util.ArrayList;

/**
 * Curso: Análise e Desenvolvimento de Sistemas
 * Disciplina: Algoritmos e Estrutura de Dados
 * Unidade 2 - Atividade 2
 * 
 * Exercício 3: Mesclar Listas Intercalando Elementos
 * 
 * Enunciado:
 * Suponha que você está gerenciando duas listas de convidados para um evento e deseja
 * criar uma nova lista com os nomes intercalados das listas originais. Implemente uma
 * função que receba duas listas de convidados e retorne uma nova lista com os elementos intercalados.
 */
public class Exercicio03_MesclarListas {

    public static void main(String[] args) {
        ArrayList<String> convidadosVIP = new ArrayList<String>();
        convidadosVIP.add("Ana Beatriz (VIP)");
        convidadosVIP.add("Carlos Henrique (VIP)");
        convidadosVIP.add("Daniela Rocha (VIP)");
        convidadosVIP.add("Eduardo Silveira (VIP)");

        ArrayList<String> convidadosGeral = new ArrayList<String>();
        convidadosGeral.add("Fernanda Lima (Geral)");
        convidadosGeral.add("Gabriel Martins (Geral)");
        convidadosGeral.add("Helena Castro (Geral)");
        convidadosGeral.add("Igor Ferreira (Geral)");
        convidadosGeral.add("Juliana Mendes (Geral)");
        convidadosGeral.add("Lucas Andrade (Geral)"); // Lista 2 com mais convidados

        System.out.println("==================================================");
        System.out.println("        ORGANIZADOR DE EVENTOS: MESCLAR LISTAS    ");
        System.out.println("==================================================");

        System.out.println("\n[LISTA 1 - Convidados VIP (" + convidadosVIP.size() + " pessoas)]:");
        exibirLista(convidadosVIP);

        System.out.println("\n[LISTA 2 - Convidados Gerais (" + convidadosGeral.size() + " pessoas)]:");
        exibirLista(convidadosGeral);

        // Chamada da função que realiza a intercalação
        ArrayList<String> listaIntercalada = intercalarListas(convidadosVIP, convidadosGeral);

        System.out.println("\n--------------------------------------------------");
        System.out.println("[LISTA FINAL INTERCALADA (" + listaIntercalada.size() + " convidados no total)]:");
        exibirLista(listaIntercalada);
        System.out.println("==================================================");
    }

    /**
     * Intercala os elementos de duas listas de entrada em uma nova lista resultante.
     * Caso uma das listas seja maior que a outra, os elementos remanescentes
     * são adicionados ao final sequencialmente.
     * 
     * Complexidade de Tempo: O(N + M), onde N e M são os tamanhos das listas.
     * 
     * @param lista1 Primeira lista de convidados
     * @param lista2 Segunda lista de convidados
     * @return Nova lista com os elementos intercalados alternadamente
     */
    public static ArrayList<String> intercalarListas(ArrayList<String> lista1, ArrayList<String> lista2) {
        ArrayList<String> resultado = new ArrayList<String>();

        int tamanhoMaximo = Math.max(lista1.size(), lista2.size());

        for (int i = 0; i < tamanhoMaximo; i++) {
            // Adiciona elemento da primeira lista se ainda houver
            if (i < lista1.size()) {
                resultado.add(lista1.get(i));
            }

            // Adiciona elemento da segunda lista se ainda houver
            if (i < lista2.size()) {
                resultado.add(lista2.get(i));
            }
        }

        return resultado;
    }

    /**
     * Exibe os itens da lista com numeração.
     */
    public static void exibirLista(ArrayList<String> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(String.format(" %02d. %s", (i + 1), lista.get(i)));
        }
    }
}

/**
 * Curso: Análise e Desenvolvimento de Sistemas
 * Disciplina: Algoritmos e Estrutura de Dados
 * Unidade 2 - Atividade 2 (Exercício 10)
 * 
 * Classe que modela um Produto com histórico de vendas para ordenação.
 */
public class ProdutoVenda {

    private int id;
    private String nome;
    private int quantidadeVendas;
    private double preco;

    public ProdutoVenda(int id, String nome, int quantidadeVendas, double preco) {
        this.id = id;
        this.nome = nome;
        this.quantidadeVendas = quantidadeVendas;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeVendas() {
        return quantidadeVendas;
    }

    public void setQuantidadeVendas(int quantidadeVendas) {
        this.quantidadeVendas = quantidadeVendas;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return String.format("ID: %03d | %-28s | Vendas: %5d un | Preço: R$ %7.2f",
                id, nome, quantidadeVendas, preco);
    }
}

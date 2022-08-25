package br.com.nosremehj.domain.dtos;


public class ProdutoDTO {
    private String nome;
    private Long estoque;
    private double preco;

    public ProdutoDTO() {
    }

    public ProdutoDTO( String nome, Long estoque, double preco) {
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Long getEstoque() {
        return estoque;
    }
    public void setEstoque(Long estoque) {
        this.estoque = estoque;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
}

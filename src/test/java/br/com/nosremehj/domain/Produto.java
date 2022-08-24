package br.com.nosremehj.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "produto")
public class Produto extends PanacheEntity{
    private String nome;
    private Long estoque;
    private double preco;
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

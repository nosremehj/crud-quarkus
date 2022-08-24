package br.com.nosremehj.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.com.nosremehj.domain.Produto;

@ApplicationScoped
public class ProdutoService {

    public List<Produto> listar(){
        return Produto.listAll();
    }
}

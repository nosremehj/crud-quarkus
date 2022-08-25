package br.com.nosremehj.services;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import br.com.nosremehj.domain.Produto;
import br.com.nosremehj.domain.dtos.ProdutoDTO;

@ApplicationScoped
public class ProdutoService {

    public List<Produto> listar(){
        return Produto.listAll();
    }

    public Produto listarPorId(Long id){
        Produto produto = new Produto();
        Optional<Produto> produtoOptional =  Produto.findByIdOptional(id);

        if(produtoOptional.isEmpty()){
            throw new NullPointerException("Este produto não foi encontrado.");
        }

        produto = produtoOptional.get();

        return produto;
    }

    @Transactional
    public Produto create(ProdutoDTO produtoDTO){
        Produto produto = new Produto();

        produto.setNome(produtoDTO.getNome());
        produto.setEstoque(produtoDTO.getEstoque());
        produto.setPreco((produtoDTO.getPreco()));

        produto.persist();

        return produto;
    }

    @Transactional
    public void atualizar(Long id, ProdutoDTO produtoDTO){
        Produto produto = new Produto();

        Optional<Produto> produtoOptional =  Produto.findByIdOptional(id);

        if(produtoOptional.isEmpty()){
            throw new NullPointerException("Este produto não foi encontrado.");
        }

        produto = produtoOptional.get();
        
        produto.setNome(produtoDTO.getNome());
        produto.setEstoque(produtoDTO.getEstoque());
        produto.setPreco((produtoDTO.getPreco()));

        produto.persist();
    }

    @Transactional
    public void removerProduto(Long id){
        Optional<Produto> produtoOptional = Produto.findByIdOptional(id);

        if(produtoOptional.isEmpty()){
            throw new NullPointerException("Este produto não foi encontrado.");
        }
        
        Produto produto = produtoOptional.get();
        produto.delete();
    }
}

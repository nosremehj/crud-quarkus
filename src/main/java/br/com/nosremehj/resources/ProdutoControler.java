package br.com.nosremehj.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



import br.com.nosremehj.domain.Produto;
import br.com.nosremehj.domain.dtos.ProdutoDTO;
import br.com.nosremehj.services.ProdutoService;


@Path("produtos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProdutoControler {
    
    @Inject
    ProdutoService produtoService;

    @GET
    public Response listarProdutos(){
        List<Produto> produtos = produtoService.listar();

        return Response.ok(produtos).build();
    }

    @GET
    @Path("/{id}")
    public Response listarPorId(@PathParam("id") Long id){
        Produto produto = produtoService.listarPorId(id);
        return Response.ok(produto).build();
    }

    @POST
    public Response criar(ProdutoDTO produtoDTO){
        Produto produto = produtoService.create(produtoDTO);

        return Response.ok(produto).status(201).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, ProdutoDTO produtoDTO){
        produtoService.atualizar(id, produtoDTO);

        return Response.status(204).build();
    }

    @DELETE
    @Path("/{id}")
    public Response removerProduto(@PathParam("id") Long id){
        produtoService.removerProduto(id);

        return Response.status(204).build();
    }
}

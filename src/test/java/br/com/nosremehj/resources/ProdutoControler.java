package br.com.nosremehj.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



import br.com.nosremehj.domain.Produto;
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
}

package com.randradee.apiestudo.services;

import com.randradee.apiestudo.models.Produto;
import com.randradee.apiestudo.repositories.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ProdutoServiceTest {

    @Test
    void when_save_produto_it_should_return_produto() {
        // Mockar o repository
        ProdutoRepository produtoRepository = Mockito.mock(ProdutoRepository.class);
        // Instanciar o service e injetar a dependência
        ProdutoService produtoService = new ProdutoService(produtoRepository);

        // Modelar o comportamento do repository, que deve receber um Produto e retornar um Produto
        when(produtoRepository.save(any(Produto.class))).thenReturn(new Produto());

        // Criar o Produto que vai ser passado como argumento para o service
        Produto argumentProduto = new Produto();

        // Passar o produto para o service e capturar o retorno
        Produto returnedProduto = produtoService.createProduto(argumentProduto);

        assertEquals(returnedProduto.getId(), argumentProduto.getId());
        assertEquals(returnedProduto.getNome(), argumentProduto.getNome());
        assertEquals(returnedProduto.getPreco(), argumentProduto.getPreco());
    }

    @Test
    void when_get_protudos_it_should_return_all_produtos(){
        // Mockar o repository
        ProdutoRepository produtoRepository = Mockito.mock(ProdutoRepository.class);
        // Instanciar o service e injetar a dependência
        ProdutoService produtoService = new ProdutoService(produtoRepository);

        // Modelar o comportamento do repository, que deve receber um Produto e retornar um Produto
        when(produtoRepository.findAll()).thenReturn(List.of(new Produto()));

        // Capturar o retorno
        List<Produto> returnedProdutos = produtoService.getProdutos();
    }
}
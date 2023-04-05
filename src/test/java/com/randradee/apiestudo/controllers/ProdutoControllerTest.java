package com.randradee.apiestudo.controllers;

import com.randradee.apiestudo.models.Produto;
import com.randradee.apiestudo.services.ProdutoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ProdutoControllerTest {

    ProdutoService produtoService = Mockito.mock(ProdutoService.class);
    ProdutoController produtoController = new ProdutoController(produtoService);

    @Test
    void ShouldCreateProduct() {
        Produto produto = new Produto(1L, "produto teste", 1.0);
        when(this.produtoService.createProduto(produto)).thenReturn(produto);

        Produto returnedProduto = produtoController.createProduto(produto);

        assertEquals(1L, returnedProduto.getId());
        assertEquals("produto teste", returnedProduto.getNome());
        assertEquals(1.0, returnedProduto.getPreco());
    }

    @Test
    void getProdutos() {



    }

    @Test
    void getProduto() {
    }

    @Test
    void updateProduto() {
    }

    @Test
    void deleteProduto() {
    }
}
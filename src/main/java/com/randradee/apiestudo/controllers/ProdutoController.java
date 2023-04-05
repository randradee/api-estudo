package com.randradee.apiestudo.controllers;

import com.randradee.apiestudo.models.Produto;
import com.randradee.apiestudo.repositories.ProdutoRepository;
import com.randradee.apiestudo.services.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
    private final ProdutoService produtoService;
    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Produto createProduto(@RequestBody Produto produto){
        return produtoService.createProduto(produto);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> getProdutos(){
        return produtoService.getProdutos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Produto> getProduto(@PathVariable ("id") Long id){
        return produtoService.getProduto(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Produto> updateProduto(@PathVariable (value = "id") Long id, @RequestBody Produto produto){
        return produtoService.updateProduto(id, produto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteProduto(@PathVariable(value = "id") Long id) {
        return produtoService.deleteProduto(id);
    }
}

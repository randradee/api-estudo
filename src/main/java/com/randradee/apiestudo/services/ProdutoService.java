package com.randradee.apiestudo.services;

import com.randradee.apiestudo.models.Produto;
import com.randradee.apiestudo.repositories.ProdutoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto createProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> getProdutos() {
        return produtoRepository.findAll();
    }

    public ResponseEntity<Produto> getProduto(Long id) {
        return produtoRepository.findById(id)
                .map(produto -> ResponseEntity.ok().body(produto))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Produto> updateProduto(Long id, Produto updatedProduto) {
        return produtoRepository.findById(id)
                .map(produtoToUpdate -> {
                    produtoToUpdate.setNome(updatedProduto.getNome());
                    produtoToUpdate.setPreco(updatedProduto.getPreco());
                    Produto updated = produtoRepository.save(produtoToUpdate);

                    return ResponseEntity.ok().body(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deleteProduto(Long id) {
        return produtoRepository.findById(id)
                .map(produtoToDelete -> {
                    produtoRepository.deleteById(produtoToDelete.getId());
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

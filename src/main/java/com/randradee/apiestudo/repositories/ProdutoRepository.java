package com.randradee.apiestudo.repositories;

import com.randradee.apiestudo.models.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {
    List<Produto> findAll();
    Optional<Produto> findById(Long id);
    <ProdMod extends Produto> ProdMod save(ProdMod produto);
    void deleteById(Long id);
}

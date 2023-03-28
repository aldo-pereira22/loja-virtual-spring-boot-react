package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
    
}

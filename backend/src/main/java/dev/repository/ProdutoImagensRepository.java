package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.ProdutoImagens;

public interface ProdutoImagensRepository extends JpaRepository<ProdutoImagens, Long> {
    
    
}

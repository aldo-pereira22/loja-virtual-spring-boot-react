package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    
    
}

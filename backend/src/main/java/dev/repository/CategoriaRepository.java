package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
    
}

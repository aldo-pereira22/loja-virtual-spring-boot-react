package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.Categoria;
import dev.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
    
}

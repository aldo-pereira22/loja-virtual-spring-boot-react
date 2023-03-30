package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.Pessoa;

public interface PessoaClienteRepository extends JpaRepository<Pessoa, Long> {
    
    
}

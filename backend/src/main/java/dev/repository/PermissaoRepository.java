package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import dev.entity.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
    
    List<Permissao> findByNome(String nome);
}

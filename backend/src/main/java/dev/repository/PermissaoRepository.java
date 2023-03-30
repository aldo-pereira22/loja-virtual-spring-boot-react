package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import dev.entity.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
    
    
}

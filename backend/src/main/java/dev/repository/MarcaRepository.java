package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import dev.entity.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
    
    
}

package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.Estado;

public interface EstadoRepository  extends JpaRepository<Estado, Long>{
        
}

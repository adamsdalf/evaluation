package com.truper.evaluation.repository;

import java.util.Optional;

import com.truper.evaluation.security.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    Optional<UsuarioEntity> findByUsername(String username);
}

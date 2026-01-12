package com.truper.evaluation.repository;

import com.truper.evaluation.domain.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductoRepositiry extends JpaRepository<ProductoEntity, Integer> {

  Optional<ProductoEntity> findByCodigo(String codigo);
}

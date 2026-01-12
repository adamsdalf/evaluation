package com.truper.evaluation.repository;

import com.truper.evaluation.domain.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositiry extends JpaRepository<ProductoEntity, Integer> {
}

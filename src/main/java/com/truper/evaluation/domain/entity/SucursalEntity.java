package com.truper.evaluation.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sucursales")
@Setter
@Getter
@NoArgsConstructor
public class SucursalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sucursalId;

    @Column(nullable = false, length = 50)
    private String nombre;

}

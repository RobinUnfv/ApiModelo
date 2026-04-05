package com.robin.demo.taller.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PERMISOS", schema = "FACTU")
public class PermisoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPermisos")
    @SequenceGenerator( name = "seqPermisos", sequenceName = "SEQ_PERMISOS", allocationSize = 1)
    @Column(name = "COD_PER", nullable = false)
    private Long codPer;

    @Size(max = 50)
    @NotNull
    @Column(name = "NOM_PER", nullable = false, length = 50)
    private String nomPer;

    @Size(max = 200)
    @Column(name = "DESCRIPCION", length = 200)
    private String descripcion;


}
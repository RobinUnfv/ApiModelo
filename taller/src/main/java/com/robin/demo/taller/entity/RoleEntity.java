package com.robin.demo.taller.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ROLES")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqRoles")
    @SequenceGenerator( name = "seqRoles", sequenceName = "SEQ_ROLES", allocationSize = 1)
    @Column(name = "COD_ROL", nullable = false)
    private Long codRol;

    @Size(max = 50)
    @NotNull
    @Column(name = "NOM_ROL", nullable = false, length = 50)
    private String nomRol;

    @Size(max = 200)
    @Column(name = "DESCRIPCION", length = 200)
    private String descripcion;

    @ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinTable( name = "ROLES_PERMISOS",
        joinColumns = @JoinColumn(name = "COD_ROL"),
        inverseJoinColumns = @JoinColumn(name = "COD_PER"))
    private Set<PermisoEntity> permisos = new HashSet<PermisoEntity>();


}
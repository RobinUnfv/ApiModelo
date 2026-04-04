package com.robin.demo.taller.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TAPUSU_PVEN")
public class TapusuPvenEntity {
    @EmbeddedId
    private TapusuPvenIdEntity tapusuPvenId;

    @Size(max = 150)
    @Column(name = "NOMBRE", length = 150)
    private String nombre;

    @Size(max = 2)
    @Column(name = "TIPUSUA", length = 2)
    private String tipusua;

    @Size(max = 2)
    @Column(name = "CENTRO", length = 2)
    private String centro;

    @Size(max = 1)
    @ColumnDefault("'A'")
    @Column(name = "ESTADO", length = 1)
    private String estado;

    @Size(max = 6)
    @Column(name = "COD_EMP", length = 6)
    private String codEmp;

    @Size(max = 100)
    @Column(name = "CLAVE", length = 100)
    private String clave;

    @Size(max = 50)
    @Column(name = "EMAIL", length = 50)
    private String email;

    @Column(name = "CUENTA_NO_EXPIRADA")
    private Boolean cuentaNoExpirada;

    @Column(name = "CUENTA_NO_BLOQUEADA")
    private Boolean cuentaNoBloqueada;

    @Column(name = "CREDENCIAL_NO_EXPIRADA")
    private Boolean credencialNoExpirada;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable( name = "USUARIO_ROLES",
            joinColumns = {
                    @JoinColumn(name = "NO_CIA", referencedColumnName = "NO_CIA"),
                    @JoinColumn(name = "USUARIO", referencedColumnName = "USUARIO")
            },
            inverseJoinColumns = @JoinColumn(name = "COD_ROL", referencedColumnName = "COD_ROL"))
    private Set<RoleEntity> roles = new HashSet<RoleEntity>();

}
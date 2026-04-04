package com.robin.demo.taller.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class TapusuPvenIdEntity implements Serializable {
    private static final long serialVersionUID = 1610131320155643353L;
    @Size(max = 2)
    @NotNull
    @Column(name = "NO_CIA", nullable = false, length = 2)
    private String noCia;

    @Size(max = 15)
    @NotNull
    @Column(name = "USUARIO", nullable = false, length = 15)
    private String usuario;


}
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
public class ArfaccId implements Serializable {
    private static final long serialVersionUID = -114768256182412238L;
    @Size(max = 2)
    @NotNull
    @Column(name = "NO_CIA", nullable = false, length = 2)
    private String noCia;

    @Size(max = 5)
    @NotNull
    @Column(name = "CENTRO", nullable = false, length = 5)
    private String centro;

    @Size(max = 2)
    @NotNull
    @Column(name = "TIPO_DOC", nullable = false, length = 2)
    private String tipoDoc;

    @Size(max = 4)
    @NotNull
    @Column(name = "SERIE", nullable = false, length = 4)
    private String serie;


}
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
public class ArfafeId implements Serializable {
    private static final long serialVersionUID = -1001290479578627479L;
    @Size(max = 2)
    @NotNull
    @Column(name = "NO_CIA", nullable = false, length = 2)
    private String noCia;

    @Size(max = 2)
    @NotNull
    @Column(name = "TIPO_DOC", nullable = false, length = 2)
    private String tipoDoc;

    @Size(max = 11)
    @NotNull
    @Column(name = "NO_FACTU", nullable = false, length = 11)
    private String noFactu;


}
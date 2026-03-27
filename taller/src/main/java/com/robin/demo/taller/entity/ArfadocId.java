package com.robin.demo.taller.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class ArfadocId implements Serializable {
    private static final long serialVersionUID = 2435934893626845615L;

    @Size(min = 1, max = 2, message = "El número de compañía debe tener 2 caracteres")
    @Column(name = "NO_CIA", nullable = false, length = 2)
    private String noCia;

    @Size(min = 1, max = 2, message = "El código de documento debe tener 2 caracteres")
    @Column(name = "COD_DOC", nullable = false, length = 2)
    private String codDoc;

}
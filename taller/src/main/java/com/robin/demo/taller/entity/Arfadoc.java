package com.robin.demo.taller.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Data
@Entity(name = "Arfadoc")
@Table(name = "ARFADOC")
public class Arfadoc {
    @EmbeddedId
    private ArfadocId id;

    @Size(min = 1, max = 30, message = "La descripción debe tener entre 1 y 30 caracteres")
    @Column(name = "DESCRIPCION", length = 30)
    private String descripcion;

    @Size(min = 1, max = 1, message = "El estado debe tener 1 caracter")
    @ColumnDefault("'A'")
    @Column(name = "ESTADO", length = 1)
    private String estado;

    @Size(min = 1, max = 2, message = "El tipo debe tener entre 1 y 2 caracteres")
    @Column(name = "TIPO", length = 2)
    private String tipo;

}

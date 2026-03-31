package com.robin.demo.taller.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Data
@Entity
@Table(name = "ARFACC")
public class Arfacc {
    @EmbeddedId
    private ArfaccId arfaccId;

    @Column(name = "CONS_DESDE")
    private Long consDesde;

    @Column(name = "LINEAS")
    private Short lineas;

    @Size(max = 4)
    @Column(name = "TIPO_M", length = 4)
    private String tipoM;

    @Size(max = 1)
    @ColumnDefault("'S'")
    @Column(name = "ACTIVO", length = 1)
    private String activo;

    @Size(max = 3)
    @Column(name = "NO_CABA", length = 3)
    private String noCaba;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "NO_CIA", referencedColumnName = "NO_CIA", insertable = false, updatable = false),
            @JoinColumn(name = "TIPO_DOC", referencedColumnName = "COD_DOC", insertable = false, updatable = false)
    })
    private Arfadoc arfadoc;


}
package com.robin.demo.taller.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "ARFAFE")
public class Arfafe {
    @EmbeddedId
    private ArfafeId arfafeId;

    @Size(max = 11)
    @Column(name = "NO_CLIENTE", length = 11)
    private String noCliente;

    @Column(name = "FECHA")
    private LocalDate fecha;

    @Size(max = 2)
    @Column(name = "TIPO_CLIENTE", length = 2)
    private String tipoCliente;

    @Size(max = 80)
    @Column(name = "NBR_CLIENTE", length = 80)
    private String nbrCliente;

    @Size(max = 3)
    @Column(name = "MONEDA", length = 3)
    private String moneda;

    @Size(max = 10)
    @Column(name = "NO_ORDEN", length = 10)
    private String noOrden;

    @Column(name = "TOTAL", precision = 11, scale = 3)
    private BigDecimal total;

    @Size(max = 1)
    @Column(name = "ESTADO", length = 1)
    private String estado;


}
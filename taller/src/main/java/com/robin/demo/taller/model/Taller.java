package com.robin.demo.taller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class Taller {
    private Long id;
    private String nombre;
    private String descripcion;
}

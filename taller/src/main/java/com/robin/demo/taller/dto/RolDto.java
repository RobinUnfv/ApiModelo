package com.robin.demo.taller.dto;

import lombok.Data;

import java.util.Set;

@Data
public class RolDto {
    private Long codRol;
    private String nomRol;
    private String descripcion;
    private Set<PermisoDto> permisos;
}

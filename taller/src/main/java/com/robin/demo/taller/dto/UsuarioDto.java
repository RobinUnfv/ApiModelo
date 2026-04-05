package com.robin.demo.taller.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UsuarioDto {
    private String noCia;
    private String usuario;
    private String nombre;
    private String tipusua;
    private String centro;
    private String estado;
    private String codEmp;
    private String email;
    private Boolean cuentaNoExpirada;
    private Boolean cuentaNoBloqueada;
    private Boolean credencialNoExpirada;
    private Set<RolDto> roles;
}

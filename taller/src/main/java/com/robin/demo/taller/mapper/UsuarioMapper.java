package com.robin.demo.taller.mapper;

import com.robin.demo.taller.dto.PermisoDto;
import com.robin.demo.taller.dto.RolDto;
import com.robin.demo.taller.dto.UsuarioDto;
import com.robin.demo.taller.entity.PermisoEntity;
import com.robin.demo.taller.entity.RoleEntity;
import com.robin.demo.taller.entity.TapusuPvenEntity;

import java.util.stream.Collectors;

public class UsuarioMapper {

    public static UsuarioDto toUsuarioDTO(TapusuPvenEntity entity) {
        UsuarioDto dto = new UsuarioDto();
        dto.setNoCia(entity.getTapusuPvenId().getNoCia());
        dto.setUsuario(entity.getTapusuPvenId().getUsuario());
        dto.setNombre(entity.getNombre());
        dto.setTipusua(entity.getTipusua());
        dto.setCentro(entity.getCentro());
        dto.setEstado(entity.getEstado());
        dto.setCodEmp(entity.getCodEmp());
        dto.setEmail(entity.getEmail());
        dto.setCuentaNoExpirada(entity.getCuentaNoExpirada());
        dto.setCuentaNoBloqueada(entity.getCuentaNoBloqueada());
        dto.setCredencialNoExpirada(entity.getCredencialNoExpirada());

        if (entity.getRoles() != null) {
            dto.setRoles(entity.getRoles().stream()
                    .map(UsuarioMapper::toRoleDTO)
                    .collect(Collectors.toSet()));
        }
        return dto;
    }

    private static RolDto toRoleDTO(RoleEntity role) {
        RolDto dto = new RolDto();
        dto.setCodRol(role.getCodRol());
        dto.setNomRol(role.getNomRol());
        dto.setDescripcion(role.getDescripcion());

        if (role.getPermisos() != null) {
            dto.setPermisos(role.getPermisos().stream()
                    .map(UsuarioMapper::toPermisoDTO)
                    .collect(Collectors.toSet()));
        }
        return dto;
    }

    private static PermisoDto toPermisoDTO(PermisoEntity permiso) {
        PermisoDto dto = new PermisoDto();
        dto.setCodPer(permiso.getCodPer());
        dto.setNomPer(permiso.getNomPer());
        dto.setDescripcion(permiso.getDescripcion());
        return dto;
    }
}

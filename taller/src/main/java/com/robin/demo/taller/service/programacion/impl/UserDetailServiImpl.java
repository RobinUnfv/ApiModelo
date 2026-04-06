package com.robin.demo.taller.service.programacion.impl;

import com.robin.demo.taller.dto.UsuarioDto;
import com.robin.demo.taller.entity.TapusuPvenEntity;
import com.robin.demo.taller.entity.TapusuPvenIdEntity;
import com.robin.demo.taller.mapper.UsuarioMapper;
import com.robin.demo.taller.repositori.ITapusuPvenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiImpl implements UserDetailsService {

    @Autowired
    private ITapusuPvenRepo tapusuPvenRepo;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TapusuPvenIdEntity tapusuPvenIdEntity = new TapusuPvenIdEntity();
        tapusuPvenIdEntity.setUsuario(username);
        tapusuPvenIdEntity.setNoCia("01");
        TapusuPvenEntity tapusuPvenEntity = tapusuPvenRepo.findById(tapusuPvenIdEntity).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));
        UsuarioDto usuarioDto = UsuarioMapper.toUsuarioDTO(tapusuPvenEntity);

        List<SimpleGrantedAuthority> authorityLis = new ArrayList<>();
        usuarioDto.getRoles().forEach(role -> authorityLis.add(new SimpleGrantedAuthority( "ROLE_".concat(role.getNomRol()) )));

        usuarioDto.getRoles().stream()
                .flatMap( role -> role.getPermisos().stream())
                .forEach(permiso -> authorityLis.add(new SimpleGrantedAuthority(permiso.getNomPer())));

        Boolean estadoUsuario = usuarioDto.getEstado().equals("A");

        return new User(usuarioDto.getUsuario(), usuarioDto.getClave(), estadoUsuario,
                usuarioDto.getCredencialNoExpirada(),
                usuarioDto.getCuentaNoExpirada(),
                usuarioDto.getCuentaNoBloqueada() , authorityLis);
    }

}

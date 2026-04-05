package com.robin.demo.taller.service.programacion.info;

import com.robin.demo.taller.dto.UsuarioDto;
import com.robin.demo.taller.entity.TapusuPvenEntity;
import com.robin.demo.taller.entity.TapusuPvenIdEntity;
import com.robin.demo.taller.service.gereric.IGenericService;

public interface ITapusuPvenServi extends IGenericService<TapusuPvenEntity, TapusuPvenIdEntity> {

    UsuarioDto getID(String noCia, String usuario) throws Exception;
}

package com.robin.demo.taller.service.programacion.info;

import com.robin.demo.taller.entity.Arfadoc;
import com.robin.demo.taller.entity.ArfadocId;
import com.robin.demo.taller.service.gereric.IGenericService;

import java.util.List;

public interface IArfadocService extends IGenericService<Arfadoc, ArfadocId> {
    List<Arfadoc> getAllArfadoc(String noCia);
    Arfadoc crearArfadoc(Arfadoc arfadoc);

    List<Arfadoc> buscarDescripDoc(String noCia, String descripcion);

}

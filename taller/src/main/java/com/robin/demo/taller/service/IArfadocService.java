package com.robin.demo.taller.service;

import com.robin.demo.taller.entity.Arfadoc;
import com.robin.demo.taller.entity.ArfadocId;

import java.util.List;

public interface IArfadocService {
    Arfadoc getArfadoc(ArfadocId id);
    List<Arfadoc> getAllArfadoc(String noCia);
    Arfadoc crearArfadoc(Arfadoc arfadoc);
    List<Arfadoc> listaDocumentosNoCia(String noCia);
    List<Arfadoc> buscarDescripDoc(String noCia, String descripcion);
}

package com.robin.demo.taller.service;

import com.robin.demo.taller.entity.Arfadoc;
import com.robin.demo.taller.entity.ArfadocId;
import com.robin.demo.taller.repositori.IArfadocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArfadocServiceImpl implements IArfadocService {

    @Autowired
    private IArfadocRepo arfadocRepo;

    @Override
    public Arfadoc getArfadoc(ArfadocId id) {
        return arfadocRepo.findById(id).orElse(null);
    }

    @Override
    public List<Arfadoc> getAllArfadoc(String noCia) {
        return arfadocRepo.findAll();
    }

    @Override
    public Arfadoc crearArfadoc(Arfadoc arfadoc) {
        return arfadocRepo.save(arfadoc);
    }

    @Override
    public List<Arfadoc> listaDocumentosNoCia(String noCia) {
        return arfadocRepo.listaDocumentosNoCia(noCia);
    }

    @Override
    public List<Arfadoc> buscarDescripDoc(String noCia, String descripcion) {
        descripcion = descripcion == null ? "" : "%"+descripcion.toUpperCase().trim()+"%";
        return arfadocRepo.buscarDescripDoc(noCia, descripcion);
    }
}

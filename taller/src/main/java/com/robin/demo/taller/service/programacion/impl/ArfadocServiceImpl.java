package com.robin.demo.taller.service.programacion.impl;

import com.robin.demo.taller.entity.Arfadoc;
import com.robin.demo.taller.entity.ArfadocId;
import com.robin.demo.taller.repositori.IArfadocRepo;
import com.robin.demo.taller.service.programacion.info.IArfadocService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ArfadocServiceImpl implements IArfadocService {

    @Autowired
    private IArfadocRepo arfadocRepo;

    @Override
    public Arfadoc buscarPorCodigo(ArfadocId arfadocId) {
        return arfadocRepo.findById(arfadocId).orElse(null);
    }

    @Override
    public List<Arfadoc> findAll() {
        return arfadocRepo.findAll();
    }

    @Override
    public List<Arfadoc> findByLike(Arfadoc arfadoc) {
        return List.of();
    }

    @Override
    public Arfadoc save(Arfadoc arfadoc) {
        return arfadocRepo.save(arfadoc);
    }

    @Override
    public Arfadoc update(Arfadoc arfadoc) {
        return arfadocRepo.save(arfadoc);
    }

    @Override
    public void delete(Arfadoc arfadoc) {
        arfadocRepo.delete(arfadoc);
    }

    @Override
    public List<Arfadoc> buscarDescripDoc(String noCia, String descripcion) {
        descripcion = descripcion == null ? "" : "%" + descripcion.toUpperCase().trim() + "%";
        return arfadocRepo.buscarDescripDoc(noCia, descripcion);
    }

    @Override
    public List<Arfadoc> getAllArfadoc(String noCia) {
        return arfadocRepo.findAll();
    }

    @Override
    public Arfadoc crearArfadoc(Arfadoc arfadoc) {
        return arfadocRepo.save(arfadoc);
    }
}

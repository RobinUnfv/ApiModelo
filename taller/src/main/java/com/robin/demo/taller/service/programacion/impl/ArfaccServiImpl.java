package com.robin.demo.taller.service.programacion.impl;

import com.robin.demo.taller.entity.Arfacc;
import com.robin.demo.taller.entity.ArfaccId;
import com.robin.demo.taller.entity.ArfadocId;
import com.robin.demo.taller.repositori.IArfaccRepo;
import com.robin.demo.taller.service.exception.ServiceException;
import com.robin.demo.taller.service.programacion.info.IArfaccServi;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ArfaccServiImpl implements IArfaccServi {

    @Autowired
    private IArfaccRepo  arfaccRepo;

    @Override
    public Arfacc buscarPorCodigo(ArfaccId arfaccId ) throws ServiceException {
        return arfaccRepo.findById(arfaccId).orElse(null);
    }

    @Override
    public List<Arfacc> findAll() throws ServiceException {
        return arfaccRepo.findAll();
    }

    @Override
    public List<Arfacc> findByLike(Arfacc arfacc) throws ServiceException {
        return List.of();
    }

    @Override
    public Arfacc save(Arfacc arfacc) throws ServiceException {
        return arfaccRepo.save(arfacc);
    }

    @Override
    public Arfacc update(Arfacc arfacc) throws ServiceException {
        return null;
    }

    @Override
    public void delete(Arfacc arfacc) throws ServiceException {
       arfaccRepo.delete(arfacc);
    }
}

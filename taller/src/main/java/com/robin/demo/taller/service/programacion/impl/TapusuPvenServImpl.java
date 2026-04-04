package com.robin.demo.taller.service.programacion.impl;

import com.robin.demo.taller.entity.TapusuPvenEntity;
import com.robin.demo.taller.entity.TapusuPvenIdEntity;
import com.robin.demo.taller.repositori.ITapusuPvenRepo;
import com.robin.demo.taller.service.exception.ServiceException;
import com.robin.demo.taller.service.programacion.info.ITapusuPvenServi;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TapusuPvenServImpl implements ITapusuPvenServi {

    @Autowired
    private ITapusuPvenRepo tapusuPvenRepo;

    @Override
    public TapusuPvenEntity buscarPorCodigo(TapusuPvenIdEntity tapusuPvenIdEntity) throws ServiceException {
        return tapusuPvenRepo.findById(tapusuPvenIdEntity).orElse(null);
    }

    @Override
    public List<TapusuPvenEntity> findAll() throws ServiceException {
        return List.of();
    }

    @Override
    public List<TapusuPvenEntity> findByLike(TapusuPvenEntity tapusuPvenEntity) throws ServiceException {
        return List.of();
    }

    @Override
    public TapusuPvenEntity save(TapusuPvenEntity tapusuPvenEntity) throws ServiceException {
        return null;
    }

    @Override
    public TapusuPvenEntity update(TapusuPvenEntity tapusuPvenEntity) throws ServiceException {
        return null;
    }

    @Override
    public void delete(TapusuPvenEntity tapusuPvenEntity) throws ServiceException {

    }
}

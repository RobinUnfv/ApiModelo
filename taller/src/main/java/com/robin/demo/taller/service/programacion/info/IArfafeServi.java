package com.robin.demo.taller.service.programacion.info;

import com.robin.demo.taller.dto.ArfafeDto;
import com.robin.demo.taller.dto.ArfafeIdDto;
import com.robin.demo.taller.service.exception.ServiceException;

import java.util.List;

public interface IArfafeServi {
    public List<ArfafeDto> listaPagina(int limit, int page,String orden, String campo) throws ServiceException;
}

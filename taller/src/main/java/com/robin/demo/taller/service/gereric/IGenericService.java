package com.robin.demo.taller.service.gereric;

import com.robin.demo.taller.service.exception.ServiceException;

import java.util.List;

public interface IGenericService<T, G> {
    T buscarPorCodigo(G g) throws ServiceException;
    List<T> findAll() throws ServiceException;
    List<T> findByLike(T t) throws ServiceException;
    T save(T t) throws ServiceException;
    T update(T t) throws ServiceException;
    void delete(T t) throws ServiceException;
}

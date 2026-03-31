package com.robin.demo.taller.service.programacion.impl;

import com.robin.demo.taller.dto.ArfafeDto;
import com.robin.demo.taller.dto.ArfafeIdDto;
import com.robin.demo.taller.entity.Arfafe;
import com.robin.demo.taller.repositori.IArfafeRepo;
import com.robin.demo.taller.service.exception.ServiceException;
import com.robin.demo.taller.service.programacion.info.IArfafeServi;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class ArfafeServiImpl implements IArfafeServi {

    private static final Set<String> CAMPOS_ORDENABLES = Set.of(
            "fecha", "noCliente", "tipoCliente", "nbrCliente", "moneda", "noOrden", "total", "estado"
    );

    @Autowired
    private IArfafeRepo arfafeRepo;

    @Override
    public List<ArfafeDto> listaPagina(int limit, int page, String orden, String campo) throws ServiceException {
        if (limit <= 0 || page < 0) {
            throw new ServiceException("Los parámetros page/limit son inválidos");
        }

        if (!CAMPOS_ORDENABLES.contains(campo)) {
            throw new ServiceException("Campo de orden inválido: " + campo);
        }

        Sort.Direction direction;
        try {
            direction = Sort.Direction.fromString(orden);
        } catch (IllegalArgumentException e) {
            throw new ServiceException("El parámetro orden debe ser ASC o DESC", e);
        }

        List<Arfafe> listaArfafe = new ArrayList<>();
        arfafeRepo.findAll(Sort.by(direction, campo)).forEach(listaArfafe::add);

        int fromIndex = page * limit;
        if (fromIndex >= listaArfafe.size()) {
            return new ArrayList<>();
        }
        int toIndex = Math.min(fromIndex + limit, listaArfafe.size());

        return convertirListaArfafeDto(listaArfafe.subList(fromIndex, toIndex));

    }

    private List<ArfafeDto> convertirListaArfafeDto(List<Arfafe> listaArfafe) {
        List<ArfafeDto> listaArfafeDto = new ArrayList<ArfafeDto>();
        listaArfafe.forEach( arfafe -> {
            ArfafeIdDto  arfafeIdDto = new ArfafeIdDto();
            BeanUtils.copyProperties(arfafe.getArfafeId(), arfafeIdDto);
            ArfafeDto arfafeDto = new ArfafeDto();
            BeanUtils.copyProperties(arfafe, arfafeDto);
            arfafeDto.setArfafeId(arfafeIdDto);
            listaArfafeDto.add(arfafeDto);
        });
        return listaArfafeDto;
    }

}

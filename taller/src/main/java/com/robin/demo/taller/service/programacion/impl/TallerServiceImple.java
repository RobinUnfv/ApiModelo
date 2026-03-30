package com.robin.demo.taller.service.programacion.impl;

import com.robin.demo.taller.model.Taller;
import com.robin.demo.taller.service.programacion.info.ITallerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TallerServiceImple implements ITallerService {
    @Override
    public Taller getTaller(Long id) {
        return Taller.builder()
                .id(id)
                .nombre("Taller de Spring Boot")
                .descripcion("Aprende a crear APIs REST con Spring Boot")
                .build();
    }

    @Override
    public List<Taller> getAllTalleres() {
        List<Taller> talleres = new ArrayList<>();
        talleres.add(Taller.builder()
                .id(1L)
                .nombre("Taller de Spring Boot")
                .descripcion("Aprende a crear APIs REST con Spring Boot")
                .build());
        talleres.add(Taller.builder()
                .id(2L)
                .nombre("Taller de Java")
                .descripcion("Aprende los fundamentos de Java")
                .build());

        return talleres;
    }


    @Override
    public Taller craerTaller(Taller taller) {
        return null;
    }
}

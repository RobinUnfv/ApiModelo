package com.robin.demo.taller.service;

import com.robin.demo.taller.model.Taller;

import java.util.List;

public interface ITallerService {
    Taller getTaller(Long id);
    List<Taller> getAllTalleres();
    Taller craerTaller(Taller taller);
}

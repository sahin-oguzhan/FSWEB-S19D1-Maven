package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Vegetable;

import java.util.List;

public interface VegetableService {
    List<Vegetable> findByPriceAsc();
    List<Vegetable> findByPriceDesc();
    List<Vegetable> findByInclName(String name);
    Vegetable findById(Long id);
    Vegetable save(Vegetable vegetable);
    Vegetable remove(Long id);

}

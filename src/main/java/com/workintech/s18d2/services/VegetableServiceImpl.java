package com.workintech.s18d2.services;

import com.workintech.s18d2.dao.VegetableRepository;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.VegetableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegetableServiceImpl implements VegetableService {
    private VegetableRepository vegetableRepository;

    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public List<Vegetable> findByPriceAsc() {
        return vegetableRepository.findByPriceAsc();
    }

    @Override
    public List<Vegetable> findByPriceDesc() {
        return vegetableRepository.findByPriceDesc();
    }

    @Override
    public List<Vegetable> findByInclName(String name) {
        return vegetableRepository.findByInclName(name);
    }

    @Override
    public Vegetable findById(Long id) {
        Optional<Vegetable> vegetable = vegetableRepository.findById(id);
        if (vegetable.isPresent()) {
            return vegetable.get();
        } else {
            throw new VegetableException("Vegetable not found with ID: " + id, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public Vegetable remove(Long id) {
        Optional<Vegetable> vegetable = vegetableRepository.findById(id);
        if (vegetable.isPresent()) {
            vegetableRepository.delete(vegetable.get());
            return vegetable.get();
        } else {
            throw new VegetableException("Vegetable not found with ID: " + id, HttpStatus.NOT_FOUND);
        }

    }
}

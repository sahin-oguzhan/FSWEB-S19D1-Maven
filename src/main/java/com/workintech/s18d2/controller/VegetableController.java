package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/vegetable")
public class VegetableController {
    private VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping
    public List<Vegetable> findAll(){
        return vegetableService.findByPriceAsc();
    }

    @GetMapping("/{id}")
    public Vegetable findById(@PathVariable Long id){
        return vegetableService.findById(id);
    }

    @GetMapping("/desc")
    public List<Vegetable> findAllDesc(){
        return vegetableService.findByPriceDesc();
    }

    @PostMapping
    public Vegetable save(@RequestBody Vegetable vegetable){
        return vegetableService.save(vegetable);
    }

    @GetMapping("/name/{name}")
    public List<Vegetable> findByName(@PathVariable String name){
        return vegetableService.findByInclName(name);
    }

    @DeleteMapping("/{id}")
    public Vegetable removeVegetable(@PathVariable Long id){
        return vegetableService.remove(id);
    }
}

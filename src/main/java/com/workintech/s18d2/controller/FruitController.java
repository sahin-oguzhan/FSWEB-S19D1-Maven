package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/fruit")
public class FruitController {
    private FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping
    public List<Fruit> findAll(){
        return fruitService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public Fruit findById(@PathVariable Long id){
        return fruitService.getById(id);
    }

    @GetMapping("/desc")
    public List<Fruit> findAllDesc(){
        return fruitService.getByPriceDesc();
    }

    @PostMapping
    public Fruit save(@RequestBody Fruit fruit){
        return fruitService.save(fruit);
    }

    @GetMapping("/name/{name}")
    public List<Fruit> findByName(@PathVariable String name){
        return fruitService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Fruit removeFruit(@PathVariable Long id){
        return fruitService.delete(id);
    }
}

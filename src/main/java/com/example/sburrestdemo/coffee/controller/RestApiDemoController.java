package com.example.sburrestdemo.coffee.controller;

import com.example.sburrestdemo.coffee.model.Coffee;
import com.example.sburrestdemo.coffee.repository.CoffeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/coffees")
public class RestApiDemoController {
    private final CoffeeRepository coffeeRepository;

    public RestApiDemoController(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @GetMapping
    Iterable<Coffee> getCoffees() {
        return coffeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Coffee> getCoffeeById(@PathVariable String id) {
        return coffeeRepository.findById(id);
    }

    @PostMapping
    public Coffee postCoffee(@RequestBody Coffee coffee) {
        return coffeeRepository.save(coffee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coffee> puttCoffee(@PathVariable String id,
                                             @RequestBody Coffee coffee) {

        return (coffeeRepository.existsById(id))
                ? new ResponseEntity<>(coffeeRepository.save(coffee),
                HttpStatus.OK)
                : new ResponseEntity<>(coffeeRepository.save(coffee),
                HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteCoffee(@PathVariable String id) {
        coffeeRepository.deleteById(id);
    }
}
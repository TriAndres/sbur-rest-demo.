package com.example.sburrestdemo.coffee.repository;

import com.example.sburrestdemo.coffee.model.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee, String> {
}
package com.example.sburrestdemo.greeting;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    @Value("${greeting-name: Mirage}")
    private String name;

    @Value("${greeting-cofe=@{greeting-name} is drinking Coffee Ganador}")
    private String coffee;
    @GetMapping
    public String getName() {
        return name;
    }

    public String getCoffee() {
        return coffee;
    }
}

package com.example.sburrestdemo.greeting.controller;

import com.example.sburrestdemo.greeting.model.Greeting;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private final Greeting greeting;

    public GreetingController(Greeting greeting) {
        this.greeting = greeting;
    }

    @GetMapping
    public String getGreeting() {
        return greeting.getName();
    }

    @GetMapping("/coffee")
    public String getNameAndCoffee() {
        return greeting.getCoffee();
    }
}

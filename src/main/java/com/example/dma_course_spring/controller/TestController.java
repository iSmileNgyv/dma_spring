package com.example.dma_course_spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello";
    }

    @PostMapping("/create")
    public String create(@RequestBody String name){
        return "Hello " + name;
    }
}

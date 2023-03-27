package dev.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Hello {
    @GetMapping("/")
    public String hello(){
        return "<h1> Olá Mundo!!!</h1>"+ "<h2> "+new Date() +"</h2>";
    }
}

package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/User")
@RequiredArgsConstructor

public class UserController {
    @GetMapping
    public String getUser(){
        System.out.println("Chegou na rota pessoa");
        return "teste";
    }
}




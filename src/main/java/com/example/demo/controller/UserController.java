package com.example.demo.controller;

import com.example.demo.domain.Tag;
import com.example.demo.domain.User;
import com.example.demo.service.ServiceUser;
import com.example.demo.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/User")
@RequiredArgsConstructor
public class UserController {

    private final ServiceUser serviceUser;

    @GetMapping
    public ResponseEntity<List<User>> getUser(){
        return ResponseEntity.ok(serviceUser.getUser());
    }
}




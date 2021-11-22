package com.example.demo.controller;

import com.example.demo.domain.Tag;
import com.example.demo.domain.User;
import com.example.demo.jsonDto.TagDto;
import com.example.demo.jsonDto.UserDto;
import com.example.demo.service.ServiceUser;
import com.example.demo.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserForId(@PathVariable("userId") Long id){
        return ResponseEntity.ok(serviceUser.getUserForId(id));
    }

    @PostMapping
    public ResponseEntity<User> crUser(@RequestBody UserDto UserDto){
        return ResponseEntity.ok(serviceUser.crUser(UserDto.toDomain()));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> putUser(
            @PathVariable("userId") Long Id,
            @RequestBody User user){
        return ResponseEntity.ok(serviceUser.putUser(user, Id));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<User> deleteUser(
            @PathVariable("userId") Long Id){
        serviceUser.deleteUser(Id);
        return ResponseEntity.noContent().build();
    }
}


package com.example.demo.service;

import com.example.demo.domain.User;

import java.util.List;

public interface ServiceUser {
    User crUser(User usuario);
    List<User> getUser();
       void getUserForId(Long id);
    User putUser(User usuario);
    void deleteUser(Long id);
}

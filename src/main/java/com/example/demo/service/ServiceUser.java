package com.example.demo.service;

import com.example.demo.domain.User;

import java.util.List;

public interface ServiceUser {
    User crUser(User user);
    List<User> getUser();
    User getUserForId(Long id);
    User putUser(User user, Long Id);
    void deleteUser(Long id);
}

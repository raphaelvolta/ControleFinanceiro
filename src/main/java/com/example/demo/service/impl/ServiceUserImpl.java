package com.example.demo.service.impl;

import com.example.demo.domain.User;
import com.example.demo.service.ServiceUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUserImpl implements ServiceUser {
    @Override
    public User crUser(User usuario) {
        return null;
    }

    @Override
    public List<User> getUser() {
        return null;
    }

    @Override
    public void getUserForId(Long id) {

    }

    @Override
    public User putUser(User usuario) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}

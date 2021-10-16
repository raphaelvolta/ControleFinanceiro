package com.example.demo.service.impl;

import com.example.demo.domain.User;
import com.example.demo.repository.TagRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ServiceUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceUserImpl implements ServiceUser {

    private final UserRepository userRepository;

    @Override
    public User crUser(User usuario) {
        return null;
    }

    @Override
    public List<User> getUser() {
        System.out.println("Chegou na rota pessoa");
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

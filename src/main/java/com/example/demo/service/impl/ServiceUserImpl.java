package com.example.demo.service.impl;

import com.example.demo.domain.Tag;
import com.example.demo.domain.User;
import com.example.demo.exception.EntityAlreadyExistsException;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.repository.TagRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ServiceUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceUserImpl implements ServiceUser {

    private final UserRepository userRepository;

    @Override
    public User crUser(User user) {
        Optional<User> exists = userRepository.findByName(user.getName());
        if(exists.isPresent()){
            throw new EntityAlreadyExistsException("User with this name already exists");
        } else {
            return userRepository.save(user);
        }
    }

    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserForId(Long id) {
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public User putUser(User user, Long Id) {
        userRepository.findById(Id).orElseThrow(EntityNotFoundException::new);
        user.setId(Id);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long Id) {
        User user = userRepository.findById(Id).orElseThrow(EntityNotFoundException::new);
    userRepository.delete(user);
    }
}
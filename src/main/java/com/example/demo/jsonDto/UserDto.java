package com.example.demo.jsonDto;

import com.example.demo.domain.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {

    @JsonProperty
    private String name;


    public User toDomain(){
        return User
                .builder()
                .name(name)
                .build();
    }
}

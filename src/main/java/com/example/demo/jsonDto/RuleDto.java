package com.example.demo.jsonDto;

import com.example.demo.domain.Rule;

public class RuleDto {

    public Rule toDomain(){
        return Rule
                .builder()
                .build();
    }
}

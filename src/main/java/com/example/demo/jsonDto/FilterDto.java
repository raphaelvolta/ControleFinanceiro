package com.example.demo.jsonDto;

import com.example.demo.domain.Filter;
import com.example.demo.domain.FilterType;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FilterDto {

    @JsonProperty
    private FilterType type;

    @JsonProperty
    private String value;

    public Filter toDomain(){
        return Filter
                .builder()
                .type(type)
                .value(value)
                .build();
    }
}

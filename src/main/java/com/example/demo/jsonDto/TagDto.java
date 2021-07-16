package com.example.demo.jsonDto;

import com.example.demo.domain.Tag;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TagDto {

    @JsonProperty
    private String description;

    @JsonProperty
    private String icon;

    public Tag toDomain(){
        return Tag
                .builder()
                .description(description)
                .icon(icon)
                .build();
    }
}

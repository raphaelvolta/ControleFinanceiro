package com.example.demo.jsonDto;

import com.example.demo.domain.Filter;
import com.example.demo.domain.Rule;
import com.example.demo.domain.Tag;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RuleDto {

    @JsonProperty
    private Integer filterId;

    @JsonProperty
    private Integer tagId;

    public Rule toDomain(){
        return Rule
                .builder()
                .filter(Filter.builder().filterId(filterId).build())
                .tag(Tag .builder().tagId(tagId).build())
                .build();
    }
}

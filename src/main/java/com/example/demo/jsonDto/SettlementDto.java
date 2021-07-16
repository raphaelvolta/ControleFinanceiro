package com.example.demo.jsonDto;

import com.example.demo.domain.Settlement;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class SettlementDto {

    @JsonProperty
    private String description;
    @JsonProperty
    private LocalDateTime dateTime;
    @JsonProperty
    private Double value;

    public Settlement toDomain(){
        return Settlement
                .builder()
                .description(this.description)
                .dateTime(this.dateTime)
                .value(this.value)
                .build();
    }
}

package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "filter")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Filter {

    @Id
    @Column(name = "filter_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer filterId;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private FilterType type;

    @Column(name = "value")
    private String value;
}

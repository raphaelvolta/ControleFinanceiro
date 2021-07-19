package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rule")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Rule {

    @Id
    @Column(name = "rule_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ruleId;

    @ManyToMany
    @JoinTable(name="rule_filter", joinColumns=
            {@JoinColumn(name="rule_id")}, inverseJoinColumns=
            {@JoinColumn(name="filter_id")})
    private List<Filter> filter;

    @ManyToMany
    @JoinTable(name="rule_tag", joinColumns=
            {@JoinColumn(name="rule_id")}, inverseJoinColumns=
            {@JoinColumn(name="tag_id")})
    private List<Tag> tag;
}

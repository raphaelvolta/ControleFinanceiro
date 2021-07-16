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
@Table(name = "rule")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Rule {

    @Id
    @Column(name = "rule_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ruleId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "filter_id", referencedColumnName = "filter_id")
    private Filter filter;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tag_id", referencedColumnName = "tag_id")
    private Tag tag;
}

package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "settlement")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Settlement {

    @Id
    @Column(name = "settlement_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer settlementId;

    @Column(name = "description")
    private String description;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "settlement_tag", joinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "settlement_id"))
    private List<Tag> tags;
}

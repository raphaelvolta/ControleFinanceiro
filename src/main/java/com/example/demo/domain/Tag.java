package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tag")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Tag implements Serializable {

    @Id
    @Column(name = "tagId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tagId;

    @Column(name = "description")
    private String description;

    @Column(name = "icon")
    private String icon;

}

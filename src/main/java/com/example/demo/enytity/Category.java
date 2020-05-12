package com.example.demo.enytity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @ManyToOne
    @JoinColumn(
            name = "parent_id"
    )
    @JsonProperty("parent_category")
    Category category;

//    @OneToMany
//    Set<Product> products;
}

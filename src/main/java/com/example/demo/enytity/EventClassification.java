package com.example.demo.enytity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class EventClassification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String type;

    @OneToMany
    List<Event> events;
}

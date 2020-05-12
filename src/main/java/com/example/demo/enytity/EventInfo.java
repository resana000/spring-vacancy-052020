package com.example.demo.enytity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class EventInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String info;

    @OneToOne
    Event event;
}

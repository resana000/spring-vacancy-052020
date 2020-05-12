package com.example.demo.enytity;

import lombok.Data;

import javax.persistence.*;
import javax.swing.*;
import java.util.List;

@Entity
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @OneToOne
    EventClassification eventClassification;

    @OneToMany
    List<EventInfo> eventInfos;
}

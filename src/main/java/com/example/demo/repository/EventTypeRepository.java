package com.example.demo.repository;

import com.example.demo.enytity.Event;
import com.example.demo.enytity.EventClassification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTypeRepository extends JpaRepository<EventClassification, Long> {

    EventClassification findByType(String type);
}

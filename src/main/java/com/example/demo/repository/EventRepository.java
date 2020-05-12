package com.example.demo.repository;

import com.example.demo.enytity.Event;
import com.example.demo.enytity.EventClassification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {
    Optional<Event> findByName(String name);
    Optional<Event> findByEventClassificationType(String eventClassificationType);
}

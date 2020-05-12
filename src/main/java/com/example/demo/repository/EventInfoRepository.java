package com.example.demo.repository;

import com.example.demo.enytity.Event;
import com.example.demo.enytity.EventInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventInfoRepository extends JpaRepository<EventInfo, Long> {
}

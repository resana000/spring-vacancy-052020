package com.example.demo.controller;

import com.example.demo.dto.EventDto;
import com.example.demo.enytity.EventClassification;
import com.example.demo.enytity.EventInfo;
import com.example.demo.repository.EventInfoRepository;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.EventTypeRepository;
import com.example.demo.service.Statistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Optional;

@RestController
@RequestMapping("/event")
public class Event {

    @Autowired
    Statistic statistic;

    @PostMapping("/add")
    ResponseEntity add(@RequestBody EventDto eventDto){
        return ResponseEntity.ok(statistic.add(eventDto));
    }

    @GetMapping("/event-list")
    public ResponseEntity getEventList(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "1") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy){
        return ResponseEntity.ok(
                statistic.getEventList(page, pageSize, sortBy));
    }
}

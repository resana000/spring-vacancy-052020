package com.example.demo.service;

import com.example.demo.dto.EventDto;
import com.example.demo.enytity.Event;
import com.example.demo.enytity.EventInfo;
import com.example.demo.repository.EventInfoRepository;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.EventTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface Statistic {

    public ResponseEntity add(@RequestBody EventDto eventDto);

    public List<Event> getEventList(Integer page, Integer pageSize, String sortBy);
}

package com.example.demo.service;

import com.example.demo.dto.EventDto;
import com.example.demo.enytity.Event;
import com.example.demo.enytity.EventInfo;
import com.example.demo.repository.EventInfoRepository;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.EventTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StatisticImpl implements  Statistic {
    @Autowired
    EventInfoRepository eventInfoRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    EventTypeRepository eventTypeRepository;

    @Override
    public ResponseEntity add(@RequestBody EventDto eventDto){

        com.example.demo.enytity.Event event =
                Optional.of(eventRepository.findByEventClassificationType(eventDto.getEventType()))
                        .get().orElseThrow(()->new RuntimeException("event not found"));

        EventInfo eventInfo= new EventInfo();
        eventInfo.setInfo(eventDto.getEventInfo());
        eventInfo.setEvent(event);
        eventInfoRepository.save(eventInfo);

        return ResponseEntity.ok(event);
    }

    @Override
    public List<Event> getEventList(
            Integer page, Integer pageSize,String sortBy){

        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(sortBy));
        Page<Event> eventPage = eventRepository.findAll(pageable);
        return eventPage.hasContent()? eventPage.getContent() : Collections.EMPTY_LIST;
    }
}

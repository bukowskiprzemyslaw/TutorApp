package com.bukowskiprzemyslaw.trackingapp.service;

import com.bukowskiprzemyslaw.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.bukowskiprzemyslaw.trackingapp.repository.EventRepository;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public void saveEvent(Event event) {
        eventRepository.save(event);

    }
@Override
    public List<Event> findLast20Events() {
        Page<Event> result = eventRepository.findAll(
                PageRequest.of(0, 20, Sort.by(Sort.Direction.ASC, "actionDate")));
        return result.toList();
    }


}


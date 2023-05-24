package com.bukowskiprzemyslaw.trackingapp.service;

import com.bukowskiprzemyslaw.trackingapp.entity.Event;
import com.bukowskiprzemyslaw.trackingapp.models.EventList;
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
    public EventList findLast20Events() {
        Page<Event> result = eventRepository.findAll(
                PageRequest.of(0, 20, Sort.by(Sort.Direction.DESC, "actionDate")));
        EventList eventList = new EventList();
        eventList.setEvents(result.getContent());
        return eventList;
    }


}


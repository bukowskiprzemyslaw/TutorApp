package com.bukowskiprzemyslaw.trackingapp.service;

import com.bukowskiprzemyslaw.entity.Event;

import java.util.List;

public interface EventService {
    void saveEvent(Event event);

    List<Event> findLast20Events();


}

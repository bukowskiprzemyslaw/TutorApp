package com.bukowskiprzemyslaw.trackingapp.service;

import com.bukowskiprzemyslaw.trackingapp.entity.Event;
import com.bukowskiprzemyslaw.trackingapp.models.EventList;

import java.util.List;

public interface EventService {
    void saveEvent(Event event);

    EventList findLast20Events();


}

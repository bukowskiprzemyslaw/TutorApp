package com.bukowskiprzemyslaw.mainapp.models;

import com.bukowskiprzemyslaw.entity.Event;

import java.util.ArrayList;
import java.util.List;

public class EventList {

    private List<Event> events;

    public EventList() {
        events = new ArrayList<>();
    }

    public List<Event> getEvents() {
        return events;
    }

    // standard constructor and getter/setter
}
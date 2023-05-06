package com.bukowskiprzemyslaw.trackingapp.models;

import com.bukowskiprzemyslaw.trackingapp.entity.Event;

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

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    // standard constructor and getter/setter
}
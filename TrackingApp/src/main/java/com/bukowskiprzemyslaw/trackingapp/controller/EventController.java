package com.bukowskiprzemyslaw.trackingapp.controller;

import com.bukowskiprzemyslaw.models.EventModel;
import com.bukowskiprzemyslaw.trackingapp.service.EventService;
import com.bukowskiprzemyslaw.trackingapp.utils.Utils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bukowskiprzemyslaw.entity.Event;


import java.time.LocalDateTime;

    @RestController
    @RequestMapping("/tracking")

    public class EventController {
        private final EventService eventService;

        @Autowired
        public EventController(EventService eventService) {
            this.eventService = eventService;
        }

        @PostMapping("/event")
        public ResponseEntity<?> addEvent(HttpServletRequest servletRequest, @RequestBody EventModel eventModel) {
            String ipAddress = Utils.getIpAddress(servletRequest);
            Event event = new Event(ipAddress, eventModel.actionType, eventModel.tutorId, LocalDateTime.now());
            eventService.saveEvent(event);
            return ResponseEntity.ok().build();
        }

        @GetMapping("/log")
        public ResponseEntity<?> getLog() {
            return ResponseEntity.ok(eventService.findLast20Events());
        }

    }


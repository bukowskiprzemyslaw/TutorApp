package com.bukowskiprzemyslaw.trackingapp.service;

import com.bukowskiprzemyslaw.trackingapp.entity.Event;
import com.bukowskiprzemyslaw.trackingapp.models.EventList;
import com.bukowskiprzemyslaw.trackingapp.repository.EventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EventServiceImplTests {

    @Mock
    private EventRepository eventRepository;

    private EventServiceImpl eventService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        eventService = new EventServiceImpl(eventRepository);
    }

    @Test
    void saveEvent_shouldSaveEvent() {
        // Arrange
        Event event = new Event();

        // Act
        eventService.saveEvent(event);

        // Assert
        verify(eventRepository, times(1)).save(event);
    }

    @Test
    void findLast20Events_shouldReturnEventList() {
        // Arrange
        List<Event> events = new ArrayList<>();
        events.add(new Event());
        events.add(new Event());
        events.add(new Event());
        Page<Event> eventPage = new PageImpl<>(events);

        when(eventRepository.findAll(any(PageRequest.class))).thenReturn(eventPage);

        // Act
        EventList result = eventService.findLast20Events();

        // Assert
        assertEquals(events, result.getEvents());
        verify(eventRepository, times(1)).findAll(PageRequest.of(0, 20, Sort.by(Sort.Direction.DESC, "actionDate")));
    }
}
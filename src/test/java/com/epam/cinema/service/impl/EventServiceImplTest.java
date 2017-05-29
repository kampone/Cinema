package com.epam.cinema.service.impl;

import com.epam.cinema.model.Event;
import com.epam.cinema.repository.EventRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class EventServiceImplTest {

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private EventServiceImpl eventService;

    private Event event = new Event();

    @Test
    public void save() throws Exception {
        eventService.save(event);

        verify(eventRepository).saveEvent(event);
    }

    @Test
    public void remove() throws Exception {
        eventService.remove(event);

        verify(eventRepository).removeEvent(event);
    }

    @Test
    public void removeById() throws Exception {
        eventService.remove(1L);

        verify(eventRepository).removeEventWithId(1L);
    }

    @Test
    public void getById() throws Exception {
        eventService.getById(1L);

        verify(eventRepository).getEventById(1L);
    }

    @Test
    public void getByName() throws Exception {
        eventService.getByName("name");

        verify(eventRepository).getEventByName("name");
    }

    @Test
    public void getAll() throws Exception {
        eventService.getAll();

        verify(eventRepository).getAllEvents();
    }

}
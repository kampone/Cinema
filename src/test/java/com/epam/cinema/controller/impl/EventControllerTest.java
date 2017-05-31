package com.epam.cinema.controller.impl;

import com.epam.cinema.model.Event;
import com.epam.cinema.service.AuditoriumService;
import com.epam.cinema.service.EventService;
import com.epam.cinema.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class EventControllerTest {

    @Mock
    private AuditoriumService auditoriumService;

    @Mock
    private EventService eventService;

    @Mock
    private UserService userService;

    @Mock
    private HttpSession session;

    @Mock
    private Model model;

    @InjectMocks
    private EventController eventController;

    @Test
    public void getAllEvents() throws Exception {
        when(userService.getAll()).thenReturn(Collections.emptySet());

        eventController.getAllEvents(model, session);

        verify(userService).getAll();
        verify(userService).isAdmin(anyString());
        verify(session, times(2)).setAttribute(anyString(), anyObject());
        verify(eventService).getAll();
        verify(model).addAttribute(anyString(), anyObject());
    }

    @Test
    public void getAllEvents1() throws Exception {
        Long eventId = 1L;

        eventController.getAllEvents(eventId, model);

        verify(eventService).getById(eventId);
        verify(model).addAttribute(anyString(), anyObject());
    }

    @Test
    public void addEventForm() throws Exception {
        String page = eventController.addEventForm();

        assertEquals("addevent", page);
    }

    @Test
    public void addEvent() throws Exception {
        Event event = new Event();

        String page = eventController.addEvent(event, model);

        verify(model).addAttribute(anyString(), anyObject());
        verify(eventService).save(event);
        assertEquals("redirect:/", page);
    }

    @Test
    public void deleteEvent() throws Exception {
        Long id = 1L;

        String page = eventController.deleteEvent(id);

        verify(eventService).remove(id);
        assertEquals("redirect:/", page);
    }

    @Test
    public void deleteEvent_WithName() throws Exception {
        String name = "name";

        String page = eventController.deleteEvent(name, model);

        verify(eventService).getByName(name);
        verify(model).addAttribute(anyString(), anyObject());
        assertEquals("index", page);
    }
}
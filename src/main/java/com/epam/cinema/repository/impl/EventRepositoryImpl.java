package com.epam.cinema.repository.impl;

import com.epam.cinema.model.Event;
import com.epam.cinema.repository.EventRepository;

import javax.annotation.Resource;
import java.util.List;

public class EventRepositoryImpl implements EventRepository{

    @Resource
    private List<Event> events;

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public void save(Event event) {
        events.add(event);
    }

    @Override
    public void remove(Event event) {
        events.remove(event);
    }

    @Override
    public Event getById(Integer id) {
        return events.stream().filter(event -> event.getId().equals(id)).findFirst().get();
    }

    @Override
    public Event getByName(String name) {
        return events.stream().filter(event -> event.getName().equals(name)).findFirst().get();
    }

    @Override
    public List<Event> getAll() {
        return events;
    }
}

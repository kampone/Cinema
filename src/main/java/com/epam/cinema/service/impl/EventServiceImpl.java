package com.epam.cinema.service.impl;

import com.epam.cinema.model.Event;
import com.epam.cinema.repository.EventRepository;
import com.epam.cinema.service.EventService;

import java.util.List;

public class EventServiceImpl implements EventService {

    private EventRepository repository;

    public EventServiceImpl(EventRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Event event) {
        repository.save(event);
    }

    @Override
    public void remove(Event event) {
        repository.remove(event);
    }

    @Override
    public void remove(Long eventId) {
        repository.remove(eventId);
    }

    @Override
    public Event getById(Long id) {
        return repository.getById(id);
    }

    @Override
    public Event getByName(String name) {
        return repository.getByName(name);
    }

    @Override
    public List<Event> getAll() {
        return repository.getAll();
    }

}

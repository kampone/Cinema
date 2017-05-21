package com.epam.cinema.repository;

import com.epam.cinema.model.Event;

import java.util.List;

public interface EventRepository {
    /**
     * Create new event
     *
     * @param event entity should be persisted
     */
    void saveEvent(Event event);

    /**
     * Remove event
     *
     * @param event entity should be deleted
     */
    void removeEvent(Event event);

    void removeEventWithId(Long eventId);

    /**
     * Find event by id. Return null if no event with such id
     *
     * @param id event's Id
     * @return event with specified id
     */
    Event getEventById(Long id);

    /**
     * Find event by name. Return null if no event with such name
     *
     * @param name event's name
     * @return event with specified name
     */
    Event getEventByName(String name);

    /**
     * Find all persisted events
     *
     * @return all users
     */
    List<Event> getAllEvents();
}

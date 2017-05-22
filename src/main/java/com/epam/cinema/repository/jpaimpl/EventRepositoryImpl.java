package com.epam.cinema.repository.jpaimpl;

import com.epam.cinema.model.Event;
import com.epam.cinema.repository.EventRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
@Profile("jpa")
public class EventRepositoryImpl implements EventRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveEvent(Event event) {
        entityManager.persist(event);
    }

    @Override
    public void removeEvent(Event event) {
        entityManager.remove(event);
    }

    @Override
    public void removeEventWithId(Long eventId) {
        Event event = entityManager.find(Event.class, eventId);
        entityManager.remove(event);
    }

    @Override
    public Event getEventById(Long id) {
        return entityManager.createNamedQuery("findEventWithId", Event.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public Event getEventByName(String name) {
        return entityManager.createNamedQuery("findAllEventWithName", Event.class).setParameter("name", name).getSingleResult();
    }

    @Override
    public List<Event> getAllEvents() {
        return entityManager.createNamedQuery("findAllEvents", Event.class).getResultList();
    }
}

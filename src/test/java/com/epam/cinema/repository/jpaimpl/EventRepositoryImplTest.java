package com.epam.cinema.repository.jpaimpl;

import com.epam.cinema.model.Event;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class EventRepositoryImplTest {
    @Mock
    private EntityManager entityManager;

    @InjectMocks
    private EventRepositoryImpl eventRepository;

    @Test
    public void saveEvent() throws Exception {
        Event event = new Event();

        eventRepository.saveEvent(event);

        entityManager.persist(event);
    }

    @Test
    public void removeEventWithId() throws Exception {
        Long id = 1L;
        Event event = new Event();

        when(entityManager.find(Event.class, id)).thenReturn(event);

        eventRepository.removeEventWithId(id);

        verify(entityManager).find(Event.class, id);
    }

    @Test
    public void getEventById() throws Exception {
        Long id = 1L;
        TypedQuery query = mock(TypedQuery.class);

        when(entityManager.createNamedQuery("findEventWithId", Event.class)).thenReturn(query);
        when(query.setParameter("id", id)).thenReturn(query);

        eventRepository.getEventById(id);

        verify(entityManager).createNamedQuery("findEventWithId", Event.class);
        verify(query).setParameter("id", id);
        verify(query).getSingleResult();
    }

    @Test
    public void getEventByName() throws Exception {
        String name = "name";
        TypedQuery query = mock(TypedQuery.class);

        when(entityManager.createNamedQuery("findAllEventWithName", Event.class)).thenReturn(query);
        when(query.setParameter("name", name)).thenReturn(query);

        eventRepository.getEventByName(name);

        verify(entityManager).createNamedQuery("findAllEventWithName", Event.class);
        verify(query).setParameter("name", name);
        verify(query).getSingleResult();
    }

    @Test
    public void getAllEvents() throws Exception {
        TypedQuery query = mock(TypedQuery.class);

        when(entityManager.createNamedQuery("findAllEvents", Event.class)).thenReturn(query);

        eventRepository.getAllEvents();

        verify(entityManager).createNamedQuery("findAllEvents", Event.class);
        verify(query).getResultList();
    }

}
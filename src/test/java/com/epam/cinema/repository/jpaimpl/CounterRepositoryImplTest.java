package com.epam.cinema.repository.jpaimpl;

import com.epam.cinema.model.Counter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class CounterRepositoryImplTest {
    @Mock
    private EntityManager entityManager;

    @InjectMocks
    private CounterRepositoryImpl counterRepository;

    @Test
    public void getCounterByEventName() throws Exception {
        String eventname = "eventname";
        TypedQuery query = mock(TypedQuery.class);

        when(entityManager.createNamedQuery("findCounterByEventName", Counter.class)).thenReturn(query);
        when(query.setParameter("eventName", eventname)).thenReturn(query);

        counterRepository.getCounterByEventName(eventname);

        verify(entityManager).createNamedQuery("findCounterByEventName", Counter.class);
        verify(query).setParameter("eventName", eventname);
        verify(query).getSingleResult();
    }

    @Test
    public void updateCounter() throws Exception {
        Counter counter = new Counter();

        counterRepository.updateCounter(counter);

        verify(entityManager).merge(counter);
    }

    @Test
    public void saveCounter() throws Exception {
        Counter counter = new Counter();

        counterRepository.saveCounter(counter);

        verify(entityManager).persist(counter);
    }

}
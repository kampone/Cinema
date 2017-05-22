package com.epam.cinema.repository.jpaimpl;

import com.epam.cinema.model.Counter;
import com.epam.cinema.repository.CounterRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
@Profile("jpa")
public class CounterRepositoryImpl implements CounterRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Counter getCounterByEventName(String eventName) {
        return entityManager.createNamedQuery("findCounterByEventName", Counter.class).setParameter("eventName", eventName).getSingleResult();
    }

    @Override
    public void updateCounter(Counter counter) {
        entityManager.merge(counter);
    }

    @Override
    public void saveCounter(Counter counter) {
        entityManager.persist(counter);
    }
}

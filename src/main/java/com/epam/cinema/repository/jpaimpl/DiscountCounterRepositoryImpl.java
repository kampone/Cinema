package com.epam.cinema.repository.jpaimpl;

import com.epam.cinema.model.DiscountCounter;
import com.epam.cinema.repository.DiscountCounterRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
@Transactional
@Profile("jpa")
public class DiscountCounterRepositoryImpl implements DiscountCounterRepository {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public DiscountCounter getDiscountCounterByUserId(Long userId) {
        return null;
    }

    @Override
    public void updateDiscountCounter(DiscountCounter counter) {
        entityManager.merge(counter);
    }

    @Override
    public void saveDiscountCounter(DiscountCounter counter) {
        entityManager.persist(counter);
    }
}

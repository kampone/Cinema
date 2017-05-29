package com.epam.cinema.repository.jpaimpl;

import com.epam.cinema.model.DiscountCounter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class DiscountCounterRepositoryImplTest {
    @Mock
    private EntityManager entityManager;

    @InjectMocks
    private DiscountCounterRepositoryImpl discountCounterRepository;

    @Test
    public void getDiscountCounterByUserId() throws Exception {
        Long id = 1L;

        discountCounterRepository.getDiscountCounterByUserId(id);

        verify(entityManager).find(DiscountCounter.class, id);
    }

    @Test
    public void updateDiscountCounter() throws Exception {
        DiscountCounter discountCounter = new DiscountCounter();

        discountCounterRepository.updateDiscountCounter(discountCounter);

        verify(entityManager).merge(discountCounter);
    }

    @Test
    public void saveDiscountCounter() throws Exception {
        DiscountCounter discountCounter = new DiscountCounter();

        discountCounterRepository.saveDiscountCounter(discountCounter);

        verify(entityManager).persist(discountCounter);
    }

}
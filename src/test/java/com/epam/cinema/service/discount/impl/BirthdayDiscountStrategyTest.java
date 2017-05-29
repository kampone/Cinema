package com.epam.cinema.service.discount.impl;

import com.epam.cinema.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class BirthdayDiscountStrategyTest {

    @InjectMocks
    private BirthdayDiscountStrategy strategy;

    @Test
    public void getDiscount_WithBirthDay() throws Exception {
        User user = new User();
        user.setBirthDate(LocalDate.now());
        LocalDateTime eventTime = LocalDateTime.now();

        Integer discount = strategy.getDiscount(user, null, eventTime, 1);

        assertEquals(Integer.valueOf(10), discount);
    }

    @Test
    public void getDiscount_BirthDayLessThanFiveDay() throws Exception {
        User user = new User();
        user.setBirthDate(LocalDate.now());
        LocalDateTime eventTime = LocalDateTime.now().minusDays(6);

        Integer discount = strategy.getDiscount(user, null, eventTime, 1);

        assertEquals(Integer.valueOf(0), discount);
    }

}
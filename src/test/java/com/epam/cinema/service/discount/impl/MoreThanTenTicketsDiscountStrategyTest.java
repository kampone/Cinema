package com.epam.cinema.service.discount.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class MoreThanTenTicketsDiscountStrategyTest {
    @InjectMocks
    private MoreThanTenTicketsDiscountStrategy strategy;

    @Test
    public void getDiscount_TenthTickets() throws Exception {
        Integer actualDiscount = strategy.getDiscount(null, null, null, 10);

        assertEquals(Integer.valueOf(50), actualDiscount);
    }

    @Test
    public void getDiscount_NotTenthTickets() throws Exception {
        Integer actualDiscount = strategy.getDiscount(null, null, null, 1);

        assertEquals(Integer.valueOf(0), actualDiscount);
    }

}
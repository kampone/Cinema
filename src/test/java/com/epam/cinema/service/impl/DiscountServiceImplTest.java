package com.epam.cinema.service.impl;

import com.epam.cinema.service.discount.impl.BirthdayDiscountStrategy;
import com.epam.cinema.service.discount.impl.MoreThanTenTicketsDiscountStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class DiscountServiceImplTest {

    @Mock
    private BirthdayDiscountStrategy strategy;

    @Mock
    private MoreThanTenTicketsDiscountStrategy moreThanTenTicketsDiscountStrategy;

    @InjectMocks
    private DiscountServiceImpl discountService;
    @Test
    public void getDiscount_withoutStrategies() throws Exception {
        discountService.setStrategies(null);
        Integer discount = discountService.getDiscount(null, null, null, null);

        assertEquals(new Integer(0), discount);
    }

    @Test
    public void getDiscount() throws Exception {
        discountService.setStrategies(asList(strategy, moreThanTenTicketsDiscountStrategy));
        when(strategy.getDiscount(null, null, null, null)).thenReturn(15);
        when(moreThanTenTicketsDiscountStrategy.getDiscount(null, null, null, null)).thenReturn(10);
        Integer discount = discountService.getDiscount(null, null, null, null);

        assertEquals(new Integer(15), discount);
    }

    @Test
    public void getDiscount_strategy() throws Exception {
        discountService.setStrategies(asList(strategy, moreThanTenTicketsDiscountStrategy));
        when(strategy.getDiscount(null, null, null, null)).thenReturn(10);
        when(moreThanTenTicketsDiscountStrategy.getDiscount(null, null, null, null)).thenReturn(15);
        Integer discount = discountService.getDiscount(null, null, null, null);

        assertEquals(new Integer(15), discount);
    }

    @Test
    public void getStrategies() throws Exception {
        discountService.setStrategies(asList(strategy, moreThanTenTicketsDiscountStrategy));

        assertEquals(asList(strategy, moreThanTenTicketsDiscountStrategy), discountService.getStrategies());
    }


}
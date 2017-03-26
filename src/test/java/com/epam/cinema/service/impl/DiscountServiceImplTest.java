package com.epam.cinema.service.impl;

import com.epam.cinema.service.discount.fakeImpl.FakeDiscountServiceImpl;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;


public class DiscountServiceImplTest {


    @Test
    public void getDiscount() throws Exception {
        DiscountServiceImpl discountService = new DiscountServiceImpl();
        discountService.setStrategies(Arrays.asList(new FakeDiscountServiceImpl()));

        Integer discount = discountService.getDiscount(null, null, null, null);

        assertEquals(new Integer(50), discount);
    }

}
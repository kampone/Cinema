package com.epam.cinema.service.discount.fakeImpl;

import org.junit.Test;

import static org.junit.Assert.*;


public class FakeDiscountServiceImplTest {

    FakeDiscountServiceImpl fakeDiscountService = new FakeDiscountServiceImpl();

    @Test
    public void getDiscount() throws Exception {
        assertEquals(new Integer(50), fakeDiscountService.getDiscount(null, null, null, null));
    }

}
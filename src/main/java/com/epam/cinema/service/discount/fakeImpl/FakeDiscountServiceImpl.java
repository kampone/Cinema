package com.epam.cinema.service.discount.fakeImpl;

import com.epam.cinema.model.Event;
import com.epam.cinema.model.User;
import com.epam.cinema.service.DiscountService;
import com.epam.cinema.service.discount.DiscountStrategy;

import java.time.LocalDateTime;

public class FakeDiscountServiceImpl implements DiscountStrategy {
    @Override
    public Integer getDiscount(User user, Event event, LocalDateTime dateTime, Integer numberOfTickets) {
        return 50;
    }
}

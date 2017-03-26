package com.epam.cinema.service.impl;

import com.epam.cinema.model.Event;
import com.epam.cinema.model.User;
import com.epam.cinema.service.DiscountService;

import java.time.LocalDateTime;

public class DiscountServiceImpl implements DiscountService {
    @Override
    public Integer getDiscount(User user, Event event, LocalDateTime dateTime, Integer numberOfTickets) {

        return null;
    }
}

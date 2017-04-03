package com.epam.cinema.service.discount.impl;

import com.epam.cinema.model.Event;
import com.epam.cinema.model.User;
import com.epam.cinema.service.discount.DiscountStrategy;

import java.time.LocalDateTime;

public class MoreThanTenTicketsDiscountStrategy implements DiscountStrategy {
    private static final int TICKETS_BORDER = 10;
    public static final Integer DISCOUNT_SIZE = 15;
    private static final int WITHOUT_DISCOUNT = 0;

    @Override
    public Integer getDiscount(User user, Event event, LocalDateTime dateTime, Integer numberOfTickets) {
            return numberOfTickets >= TICKETS_BORDER ? DISCOUNT_SIZE : WITHOUT_DISCOUNT;
    }
}

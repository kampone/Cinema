package com.epam.cinema.service.discount.impl;

import com.epam.cinema.model.Event;
import com.epam.cinema.model.User;
import com.epam.cinema.service.discount.DiscountStrategy;

import java.time.LocalDateTime;

public class MoreThanTenTicketsDiscountStrategy implements DiscountStrategy {
    private static final Integer TICKETS_BORDER = 10;
    public static final Integer DISCOUNT_SIZE = 50;
    private static final Integer WITHOUT_DISCOUNT = 0;

    @Override
    public Integer getDiscount(User user, Event event, LocalDateTime dateTime, Integer numberOfTickets) {
            return numberOfTickets % TICKETS_BORDER == 0 ? DISCOUNT_SIZE : WITHOUT_DISCOUNT;
    }
}

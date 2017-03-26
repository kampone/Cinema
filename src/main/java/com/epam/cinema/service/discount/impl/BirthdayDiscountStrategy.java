package com.epam.cinema.service.discount.impl;

import com.epam.cinema.model.Event;
import com.epam.cinema.model.User;
import com.epam.cinema.service.discount.DiscountStrategy;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class BirthdayDiscountStrategy implements DiscountStrategy {
    private static final int DAYS_BORDER = 5;
    private static final int DISCOUNT_SIZE = 10;
    private static final int WITHOUT_DISCOUNT = 0;

    @Override
    public Integer getDiscount(User user, Event event, LocalDateTime dateTime, Integer numberOfTickets) {
        return Math.abs(ChronoUnit.DAYS.between(dateTime, user.getBirthDate())) < DAYS_BORDER ? DISCOUNT_SIZE : WITHOUT_DISCOUNT;
    }
}

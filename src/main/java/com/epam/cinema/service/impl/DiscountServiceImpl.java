package com.epam.cinema.service.impl;

import com.epam.cinema.model.Event;
import com.epam.cinema.model.User;
import com.epam.cinema.service.DiscountService;
import com.epam.cinema.service.discount.DiscountStrategy;

import java.time.LocalDateTime;
import java.util.List;

public class DiscountServiceImpl implements DiscountService {

    private List<DiscountStrategy> strategies;

    @Override
    public Integer getDiscount(User user, Event event, LocalDateTime dateTime, Integer numberOfTickets) {
        return strategies.stream().mapToInt(it -> it.getDiscount(user, event, dateTime, numberOfTickets)).max().getAsInt();
    }
}

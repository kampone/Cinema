package com.epam.cinema.service.impl;

import com.epam.cinema.aspect.CountDiscountForUser;
import com.epam.cinema.model.Event;
import com.epam.cinema.model.User;
import com.epam.cinema.service.DiscountService;
import com.epam.cinema.service.discount.DiscountStrategy;

import java.time.LocalDateTime;
import java.util.List;

public class DiscountServiceImpl implements DiscountService {

    private List<DiscountStrategy> strategies;

    public List<DiscountStrategy> getStrategies() {
        return strategies;
    }

    public void setStrategies(List<DiscountStrategy> strategies) {
        this.strategies = strategies;
    }

    @Override
    @CountDiscountForUser
    public Integer getDiscount(User user, Event event, LocalDateTime dateTime, Integer numberOfTickets) {
        if (strategies!= null){
            return strategies.stream().mapToInt(it -> it.getDiscount(user, event, dateTime, numberOfTickets)).max().getAsInt();
        }
        return 0;
    }
}

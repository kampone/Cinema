package com.epam.cinema.service;

import com.epam.cinema.model.Event;
import com.epam.cinema.model.User;

import java.time.LocalDateTime;

/**
 * Counts different discounts for purchased tickets
 */
public interface DiscountService {
    /**
     * Get total discount (from 0 to 100) that can be applied to the user buying specified number of tickets for specific event and air dateTime
     * @param user user to calculate discount
     * @param event specific event
     * @param dateTime specific dateTime
     * @param numberOfTickets specified number of tickets
     * @return total discount (from 0 to 100)
     */
    Integer getDiscount(User user, Event event, LocalDateTime dateTime, Integer numberOfTickets);
}

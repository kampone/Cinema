package com.epam.cinema.service;

import com.epam.cinema.model.Event;
import com.epam.cinema.model.Seat;
import com.epam.cinema.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Manages tickets, prices, bookings
 */
public interface BookingService {
    /**
     * Returns total price for buying all tickets for specified event on specific date and time for specified seats.
     *
     * @param event    Event is needed to get base price, rating
     * @param dateTime specific date
     * @param user     User is needed to calculate discount
     * @param seats    specified seats
     * @return total price
     */
    BigDecimal getTicketsPrice(Event event, LocalDateTime dateTime, User user, List<Seat> seats);
}

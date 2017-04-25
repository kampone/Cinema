package com.epam.cinema.service;

import com.epam.cinema.model.Event;
import com.epam.cinema.model.Seat;
import com.epam.cinema.model.Ticket;
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

    /**
     * Book the ticket. Ticket should contain information about event, air dateTime, seat, and user. The user could be registered or not.
     *
     * @param ticket Ticket should contain information about event, air dateTime, seat, and user.
     */
    void bookTicket(Ticket ticket);


    void bookTicket(Long ticketId);

    /**
     * Get all purchased tickets for event for specific date and Time
     * @param event specific event
     * @param dateTime specific date and Time
     * @return purchased tickets for event for specific date and Time
     */
    List<Ticket> getPurchasedTicketsForEvent(Event event, LocalDateTime dateTime);
}

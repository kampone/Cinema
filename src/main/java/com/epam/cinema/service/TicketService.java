package com.epam.cinema.service;

import com.epam.cinema.model.Event;
import com.epam.cinema.model.Ticket;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketService {
    /**
     * Return tickets for specified event for all dates and times
     * @param event Specified event
     * @return All tickets for specified event for all dates and times
     */
    List<Ticket> getTicketsForEvent(Event event);

    /**
     * Return tickets for specified event for specified date and time
     * @param event Specified event
     * @param date Specified time
     * @return All tickets for specified event for specified date and time
     */
    List<Ticket> getTicketsForEventAndDate(Event event, LocalDateTime date);

    /**
     * Return purchased tickets for specified event for specified date and time
     * @param event Specified event
     * @param date Specified time
     * @return All purchased tickets for specified event for specified date and time
     */
    List<Ticket> getPurchasedTicketsForEventAndDate(Event event, LocalDateTime date);

    /**
     *  Return free tickets for specified event for specified date and time
     * @param event Specified event
     * @param date Specified time
     * @return All free tickets for specified event for specified date and time
     */
    List<Ticket> getFreeTicketsForEventAndDate(Event event, LocalDateTime date);

    void bookTicketWithId(Long ticketId);

    void bookTicketWithIdForUser(Long ticketId, Long userId);

    void unbookTicketWithId(Long ticketId, Long userId);

    void buyTicket(Long ticketId);

    List<Ticket> getTicketsForUser(Long id);
}

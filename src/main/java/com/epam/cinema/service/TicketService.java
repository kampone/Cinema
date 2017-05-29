package com.epam.cinema.service;

import com.epam.cinema.model.Event;
import com.epam.cinema.model.Ticket;

import java.util.List;

public interface TicketService {
    /**
     * Return tickets for specified event for all dates and times
     * @param event Specified event
     * @return All tickets for specified event for all dates and times
     */
    List<Ticket> getTicketsForEvent(Event event);

    void bookTicketWithIdForUser(Long ticketId, Long userId);

    void unbookTicketWithId(Long ticketId, Long userId);

    void buyTicket(Long ticketId);

    List<Ticket> getTicketsForUser(Long id);
}

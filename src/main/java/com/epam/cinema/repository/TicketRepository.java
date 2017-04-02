package com.epam.cinema.repository;

import com.epam.cinema.model.Ticket;

import java.util.List;

public interface TicketRepository {
    /**
     * Return all tickets
     * @return All tickets
     */
    List<Ticket> getAll();

    List<Ticket> getTicketsForUser(Long userId);

    List<Ticket> getTicketForEvent(Long eventId);

    void bookTicketForUser(Long userId);

    void unbookTicket(Ticket ticket);
}

package com.epam.cinema.repository;

import com.epam.cinema.model.Ticket;

import java.util.List;

public interface TicketRepository {
    /**
     * Return all tickets
     * @return All tickets
     */
    List<Ticket> getAllTickets();

    List<Ticket> getTicketsForUser(Long userId);

    void bookTicketForUser(Ticket ticket, Long userId);

    void saveTicket(Ticket ticket);

    void unbookTicketForUser(Ticket ticket, Long userId);

    void buyTicket(Long ticketId);
}

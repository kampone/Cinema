package com.epam.cinema.repository;

import com.epam.cinema.model.Ticket;

import java.util.List;

public interface TicketRepository {
    /**
     * Return all tickets
     * @return All tickets
     */
    List<Ticket> getTicketAll();

    List<Ticket> getTicketsForUser(Long userId);

    List<Ticket> getTicketForEvent(Long eventId);

    void bookTicketForUser(Ticket ticket, Long userId);

    void declineBookingTicket(Ticket ticket);

    void saveTicket(Ticket ticket);

    void unbookTicketForUser(Ticket ticket, Long userId);

    void buyTicket(Long ticketId);
}

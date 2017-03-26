package com.epam.cinema.repository.impl;

import com.epam.cinema.model.Ticket;
import com.epam.cinema.repository.TicketRepository;

import java.util.List;

public class TicketRepositoryImpl implements TicketRepository{
    private List<Ticket> tickets;

    public TicketRepositoryImpl() {
    }

    public TicketRepositoryImpl(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public List<Ticket> getAll() {
        return tickets;
    }
}

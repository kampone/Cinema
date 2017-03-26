package com.epam.cinema.repository.impl;

import com.epam.cinema.model.Ticket;
import com.epam.cinema.repository.TicketRepository;

import javax.annotation.Resource;
import java.util.List;

public class TicketRepositoryImpl implements TicketRepository {

    @Resource
    private List<Ticket> tickets;

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

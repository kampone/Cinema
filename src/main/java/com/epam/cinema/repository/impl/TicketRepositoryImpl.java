package com.epam.cinema.repository.impl;

import com.epam.cinema.model.Ticket;
import com.epam.cinema.repository.TicketRepository;

import javax.annotation.Resource;
import java.util.List;

public class TicketRepositoryImpl implements TicketRepository {


    @Override
    public List<Ticket> getAll() {
        return null;
    }

    @Override
    public List<Ticket> getTicketsForUser(Long userId) {
        return null;
    }

    @Override
    public List<Ticket> getTicketForEvent(Long eventId) {
        return null;
    }
}

package com.epam.cinema.repository.impl;

import com.epam.cinema.model.Ticket;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class TicketRepositoryImplTest {
    TicketRepositoryImpl ticketRepository = new TicketRepositoryImpl();
    @Test
    public void getAll() throws Exception {
        List<Ticket> tickets = Arrays.asList(
                new Ticket(),
                new Ticket(),
                new Ticket()
        );
        ticketRepository.setTickets(tickets);

        List<Ticket> actualTickets = ticketRepository.getAll();

        assertEquals(3, actualTickets.size());
        assertEquals(tickets, actualTickets);
    }

}
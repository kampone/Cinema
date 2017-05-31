package com.epam.cinema.controller.impl;

import com.epam.cinema.model.Event;
import com.epam.cinema.model.Ticket;
import com.epam.cinema.service.TicketService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class RestTicketBookControllerTest {

    @Mock
    private TicketService ticketService;

    @InjectMocks
    private RestTicketBookController bookController;

    @Test
    public void bookTicket() throws Exception {
        Long userId = 1L;
        Long id = 2L;

        bookController.bookTicket(id, userId);

        verify(ticketService).bookTicketWithIdForUser(id, userId);
    }

    @Test
    public void getSumOfTickets_WithoutTickets() throws Exception {
        Long userId = 1L;
        Long id = 2L;
        when(ticketService.getTicketsForUser(userId)).thenReturn(Collections.emptyList());

        Double sumOfTickets = bookController.getSumOfTickets(id, userId);

        verify(ticketService).getTicketsForUser(userId);
        assertEquals(Double.valueOf(0.0), sumOfTickets);
    }

    @Test
    public void getSumOfTickets() throws Exception {
        Long userId = 1L;
        Long id = 2L;

        Event event = new Event();
        event.setId(id);
        event.setBasePrice(BigDecimal.TEN);

        Ticket ticket = new Ticket();
        Ticket ticket1 = new Ticket();
        Ticket ticket2 = new Ticket();
        Ticket ticket3 = new Ticket();

        ticket.setEvent(event);
        ticket1.setEvent(event);
        ticket2.setEvent(event);
        ticket3.setEvent(event);

        List<Ticket> tickets = asList(
                ticket,
                ticket1,
                ticket2,
                ticket3
        );
        when(ticketService.getTicketsForUser(userId)).thenReturn(tickets);

        Double sumOfTickets = bookController.getSumOfTickets(id, userId);

        verify(ticketService).getTicketsForUser(userId);
        assertEquals(Double.valueOf(40.0), sumOfTickets);
    }

}
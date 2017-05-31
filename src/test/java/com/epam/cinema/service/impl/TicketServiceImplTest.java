package com.epam.cinema.service.impl;

import com.epam.cinema.model.Event;
import com.epam.cinema.model.Ticket;
import com.epam.cinema.repository.TicketRepository;
import com.epam.cinema.repository.UserTicketsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class TicketServiceImplTest {

    @Mock
    private TicketRepository ticketRepository;

    @Mock
    private UserTicketsRepository userTicketsRepository;

    @InjectMocks
    private TicketServiceImpl ticketService;

    @Test
    public void getTicketsForEvent() throws Exception {
        Event event = new Event();
        event.setId(1L);
        Ticket ticket = new Ticket();
        ticket.setEvent(event);

        when(ticketRepository.getAllTickets()).thenReturn(asList(ticket));

        List<Ticket> ticketsForEvent = ticketService.getTicketsForEvent(event);

        verify(ticketRepository).getAllTickets();
        assertTrue(ticketsForEvent.contains(ticket));
    }

    @Test
    public void bookTicketWithIdForUser() throws Exception {
        Long ticketId = 1L;
        Long userId = 1L;
        ticketService.bookTicketWithIdForUser(ticketId, userId);

        verify(ticketRepository).bookTicketForUser(Matchers.any(Ticket.class), eq(userId));
        verify(ticketRepository).getAllTickets();
    }

    @Test
    public void unbookTicketWithId() throws Exception {
        Long ticketId = 1L;
        Long userId = 1L;
        ticketService.unbookTicketWithId(ticketId, userId);

        verify(ticketRepository).unbookTicketForUser(Matchers.any(Ticket.class), eq(userId));
        verify(ticketRepository).getAllTickets();
    }

    @Test
    public void buyTicket() throws Exception {
        Long id = 1L;
        ticketService.buyTicket(id);

        verify(ticketRepository).buyTicket(id);
    }

    @Test
    public void getTicketsForUser() throws Exception {
        Long id = 1L;
        ticketService.getTicketsForUser(id);

        verify(ticketRepository).getTicketsForUser(id);
    }

}
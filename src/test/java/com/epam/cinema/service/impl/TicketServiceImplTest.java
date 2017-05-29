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
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.eq;

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

        Mockito.when(ticketRepository.getAllTickets()).thenReturn(Arrays.asList(ticket));

        List<Ticket> ticketsForEvent = ticketService.getTicketsForEvent(event);

        Mockito.verify(ticketRepository).getAllTickets();
        assertTrue(ticketsForEvent.contains(ticket));
    }

    @Test
    public void bookTicketWithIdForUser() throws Exception {
        Long ticketId = 1L;
        Long userId = 1L;
        ticketService.bookTicketWithIdForUser(ticketId, userId);

        Mockito.verify(ticketRepository).bookTicketForUser(Matchers.any(Ticket.class), eq(userId));
        Mockito.verify(ticketRepository).getAllTickets();
    }

    @Test
    public void unbookTicketWithId() throws Exception {
        Long ticketId = 1L;
        Long userId = 1L;
        ticketService.unbookTicketWithId(ticketId, userId);

        Mockito.verify(ticketRepository).unbookTicketForUser(Matchers.any(Ticket.class), eq(userId));
        Mockito.verify(ticketRepository).getAllTickets();
    }

    @Test
    public void buyTicket() throws Exception {
        Long id = 1L;
        ticketService.buyTicket(id);

        Mockito.verify(ticketRepository).buyTicket(id);
    }

    @Test
    public void getTicketsForUser() throws Exception {
        Long id = 1L;
        ticketService.getTicketsForUser(id);

        Mockito.verify(ticketRepository).getTicketsForUser(id);
    }

}
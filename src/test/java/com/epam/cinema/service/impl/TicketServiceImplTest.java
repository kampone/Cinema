package com.epam.cinema.service.impl;

import com.epam.cinema.model.Event;
import com.epam.cinema.model.Rating;
import com.epam.cinema.model.Ticket;
import com.epam.cinema.repository.TicketRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TicketServiceImplTest {

    @Mock
    private TicketRepository repository;

    @InjectMocks
    private TicketServiceImpl service;

    @Test
    public void getTicketsForEvent() throws Exception {
        Event event = new Event(2, "event2", new BigDecimal(10), Rating.MID);

        Mockito.when(repository.getAll()).thenReturn( ticketList());

        List<Ticket> actualTickets = service.getTicketsForEvent(event);

        Mockito.verify(repository).getAll();
        Assert.assertEquals(2, actualTickets.size());
    }


    @Test
    public void getTicketsForEventAndDate() throws Exception {
        Event event = new Event(2, "event2", new BigDecimal(10), Rating.MID);

        Mockito.when(repository.getAll()).thenReturn(ticketList());

        List<Ticket> actualTickets = service.getTicketsForEventAndDate(event, LocalDateTime.now());

        Mockito.verify(repository).getAll();
        Assert.assertEquals(1, actualTickets.size());
    }

    @Test
    public void getPurchasedTicketsForEventAndDate() throws Exception {
        Event event = new Event(3, "event3", new BigDecimal(10), Rating.MID);

        Mockito.when(repository.getAll()).thenReturn(ticketList());

        List<Ticket> actualTickets = service.getPurchasedTicketsForEventAndDate(event, LocalDateTime.now());

        Mockito.verify(repository).getAll();
        Assert.assertEquals(1, actualTickets.size());
    }

    @Test
    public void getFreeTicketsForEventAndDate() throws Exception {
        Event event = new Event(3, "event3", new BigDecimal(10), Rating.MID);

        Mockito.when(repository.getAll()).thenReturn(ticketList());

        List<Ticket> actualTickets = service.getFreeTicketsForEventAndDate(event, LocalDateTime.now());

        Mockito.verify(repository).getAll();
        Assert.assertEquals(1, actualTickets.size());
    }

    private List<Ticket> ticketList() {
        Event event = new Event(1, "event", new BigDecimal(10), Rating.MID);
        Event event2 = new Event(2, "event2", new BigDecimal(10), Rating.MID);
        Event event3 = new Event(3, "event3", new BigDecimal(10), Rating.MID);

        Ticket ticket = new Ticket(1, event, LocalDateTime.now(), null, null, false);
        Ticket ticket1 = new Ticket(2, event2, LocalDateTime.now(), null, null, false);
        Ticket ticket2 = new Ticket(3, event3, LocalDateTime.now(), null, null, false);
        Ticket ticket3 = new Ticket(4, event2, LocalDateTime.now().minusDays(1), null, null, true);
        Ticket ticket4 = new Ticket(5, event3, LocalDateTime.now(), null, null, true);
        return Arrays.asList(ticket, ticket1, ticket2, ticket3, ticket4);
    }
}
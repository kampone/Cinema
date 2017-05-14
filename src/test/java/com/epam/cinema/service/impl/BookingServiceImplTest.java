package com.epam.cinema.service.impl;

import com.epam.cinema.model.*;
import com.epam.cinema.service.DiscountService;
import com.epam.cinema.service.TicketService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;

@RunWith(MockitoJUnitRunner.class)
public class BookingServiceImplTest {
    @Mock
    private DiscountService discountService;

    @Mock
    private TicketService ticketService;

    @InjectMocks
    private BookingServiceImpl bookingService;

//    @Test
//    public void getTicketsPrice() throws Exception {
//        Mockito.when(discountService.getDiscount(any(User.class), any(Event.class), any(LocalDateTime.class), anyInt())).then(invocationOnMock -> 0);
//
//        BigDecimal price = bookingService.getTicketsPrice(new Event(1L, "event", new BigDecimal(10), Rating.LOW), "description", ,
//                LocalDateTime.now(),
//                new User(),
//                Arrays.asList(new Seat(1L,1, 1, false))
//        );
//
//        assertEquals(new BigDecimal(10), price);
//    }
//
//    @Test
//    public void bookTicket() throws Exception {
//        Ticket ticket = new Ticket(null, null, null, null, null, false);
//
//        bookingService.bookTicket(ticket);
//
//        assertTrue(ticket.isBooked());
//
//    }
//
//    @Test
//    public void getPurchasedTicketsForEvent() throws Exception {
//        bookingService.getPurchasedTicketsForEvent(null, null);
//
//        Mockito.verify(ticketService).getPurchasedTicketsForEventAndDate(null, null);
//    }

}
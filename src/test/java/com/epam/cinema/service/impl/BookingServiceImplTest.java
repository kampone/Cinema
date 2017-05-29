package com.epam.cinema.service.impl;

import com.epam.cinema.model.*;
import com.epam.cinema.service.DiscountService;
import com.epam.cinema.service.TicketService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class BookingServiceImplTest {
    @Mock
    private DiscountService discountService;

    @Mock
    private TicketService ticketService;

    @InjectMocks
    private BookingServiceImpl bookingService;

    @Before
    public void setUp(){
        when(discountService.getDiscount(any(User.class), any(Event.class), any(LocalDateTime.class), anyInt())).then(invocationOnMock -> 0);
    }

    @Test
    public void getTicketsPrice() throws Exception {
        BigDecimal price = bookingService.getTicketsPrice(
                new Event(1L, "event", new BigDecimal(10), Rating.LOW, "description", null, null),
                LocalDateTime.now(),
                new User(),
                Collections.singletonList(new Seat(1L, 1, 1, false, null))
        );

        assertEquals(new BigDecimal(10), price);
    }

    @Test
    public void getTicketsPrice_userWithTickets() throws Exception {
        User user = new User();
        user.setTickets(
                asList(
                        new Ticket(),
                        new Ticket()
                )
        );

        BigDecimal price = bookingService.getTicketsPrice(
                new Event(1L, "event", new BigDecimal(10), Rating.LOW, "description", null, null),
                LocalDateTime.now(),
                user,
                singletonList(new Seat(1L, 1, 1, false, null))
        );

        assertEquals(new BigDecimal(10), price);
    }

    @Test
    public void getTicketsPrice_VipSeat() throws Exception {
        BigDecimal price = bookingService.getTicketsPrice(
                new Event(1L, "event", new BigDecimal(10), Rating.LOW, "description", null, null),
                LocalDateTime.now(),
                new User(),
                singletonList(new Seat(1L, 1, 1, true, null))
        );

        assertEquals(new BigDecimal(20), price);
    }

    @Test
    public void getTicketsPrice_EventWithHighRating() throws Exception {
        BigDecimal price = bookingService.getTicketsPrice(
                new Event(1L, "event", new BigDecimal(10), Rating.HIGH, "description", null, null),
                LocalDateTime.now(),
                new User(),
                singletonList(new Seat(1L, 1, 1, false, null))
        );

        assertEquals(new BigDecimal(12), price);
    }

    @Test
    public void getTicketsPrice_VipSeatAndEventWithHighRating() throws Exception {
        BigDecimal price = bookingService.getTicketsPrice(
                new Event(1L, "event", new BigDecimal(10), Rating.HIGH, "description", null, null),
                LocalDateTime.now(),
                new User(),
                singletonList(new Seat(1L, 1, 1, true, null))
        );

        assertEquals(new BigDecimal(24), price);
    }

    @Test
    public void getTicketsPrice_VipSeatAndEventWithHighRatingWithDiscount() throws Exception {
        when(discountService.getDiscount(any(User.class), any(Event.class), any(LocalDateTime.class), anyInt())).thenReturn(5);

        BigDecimal price = bookingService.getTicketsPrice(
                new Event(1L, "event", new BigDecimal(10), Rating.LOW, "description", null, null),
                LocalDateTime.now(),
                new User(),
                singletonList(new Seat(1L, 1, 1, false, null))
        );

        assertEquals(new BigDecimal(9.5), price);
    }
}
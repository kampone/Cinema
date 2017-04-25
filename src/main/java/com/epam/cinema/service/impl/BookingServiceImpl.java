package com.epam.cinema.service.impl;

import com.epam.cinema.model.*;
import com.epam.cinema.service.BookingService;
import com.epam.cinema.service.DiscountService;
import com.epam.cinema.service.TicketService;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;

public class BookingServiceImpl implements BookingService {
    private static final int ONE_HUNDRED_PERCENTS = 100;

    private DiscountService discountService;

    private TicketService ticketService;

    public DiscountService getDiscountService() {
        return discountService;
    }

    public void setDiscountService(DiscountService discountService) {
        this.discountService = discountService;
    }

    public TicketService getTicketService() {
        return ticketService;
    }

    public void setTicketService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Override
    public BigDecimal getTicketsPrice(Event event, LocalDateTime dateTime, User user, List<Seat> seats) {
        BigDecimal price = BigDecimal.ZERO;
        Integer discount = discountService.getDiscount(user, event, dateTime, seats.size());
        BigDecimal basePrice = event.getBasePrice();
        for (Seat seat : seats) {
            if (!seat.isVip()) {
                price = price.add(basePrice);
            } else {
                price = price.add(basePrice.multiply(new BigDecimal(2)));
            }
        }
        if (event.getRating().equals(Rating.HIGH)) {
            price = price.multiply(new BigDecimal(1.2));
        }
        price = discount == BigDecimal.ZERO.intValue() ? price : price.multiply(new BigDecimal(discount / ONE_HUNDRED_PERCENTS));
        return price.round(new MathContext(2, RoundingMode.CEILING));
    }

    @Override
    public void bookTicket(Ticket ticket) {
        ticket.setBooked(true);
    }

    @Override
    public void bookTicket(Long ticketId) {
        ticketService.bookTicketWithId(ticketId);
    }

    @Override
    public List<Ticket> getPurchasedTicketsForEvent(Event event, LocalDateTime dateTime) {
        return ticketService.getPurchasedTicketsForEventAndDate(event, dateTime);
    }
}

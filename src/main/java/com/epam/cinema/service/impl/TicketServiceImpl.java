package com.epam.cinema.service.impl;


import com.epam.cinema.model.Event;
import com.epam.cinema.model.Ticket;
import com.epam.cinema.repository.TicketRepository;
import com.epam.cinema.service.TicketService;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class TicketServiceImpl implements TicketService {
    private TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public TicketRepository getTicketRepository() {
        return ticketRepository;
    }

    @Override
    public List<Ticket> getTicketsForEvent(Event event) {
        return ticketRepository.getAll().stream()
                .filter(ticket -> ticket.getEvent().equals(event))
                .collect(Collectors.toList());
    }

    @Override
    public List<Ticket> getTicketsForEventAndDate(Event event, LocalDateTime date) {
        return ticketRepository.getAll().stream()
                .filter(ticket -> ticket.getEvent().equals(event))
                .filter(ticket -> Math.abs(ChronoUnit.MINUTES.between(ticket.getDateTime(), date)) < 1)
                .collect(Collectors.toList());
    }

    @Override
    public List<Ticket> getPurchasedTicketsForEventAndDate(Event event, LocalDateTime date) {
        return ticketRepository.getAll().stream()
                .filter(ticket -> ticket.getEvent().equals(event))
                .filter(ticket -> Math.abs(ChronoUnit.MINUTES.between(ticket.getDateTime(), date)) < 1)
                .filter(Ticket::isBooked)
                .collect(Collectors.toList());
    }

    @Override
    public List<Ticket> getFreeTicketsForEventAndDate(Event event, LocalDateTime date) {
        return ticketRepository.getAll().stream()
                .filter(ticket -> ticket.getEvent().equals(event))
                .filter(ticket -> Math.abs(ChronoUnit.MINUTES.between(ticket.getDateTime(), date)) < 1)
                .filter(ticket -> !ticket.isBooked())
                .collect(Collectors.toList());
    }
}

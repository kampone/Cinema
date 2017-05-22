package com.epam.cinema.service.impl;


import com.epam.cinema.model.Event;
import com.epam.cinema.model.Ticket;
import com.epam.cinema.repository.TicketRepository;
import com.epam.cinema.repository.UserTicketsRepository;
import com.epam.cinema.service.TicketService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class TicketServiceImpl implements TicketService {
    private TicketRepository ticketRepository;
    private UserTicketsRepository userTicketsRepository;

    public TicketServiceImpl(TicketRepository ticketRepository, UserTicketsRepository userTicketsRepository) {
        this.ticketRepository = ticketRepository;
        this.userTicketsRepository = userTicketsRepository;
    }

    public TicketRepository getTicketRepository() {
        return ticketRepository;
    }

    @Override
    public List<Ticket> getTicketsForEvent(Event event) {
        return ticketRepository.getAllTickets().stream()
                .filter(ticket -> ticket.getEvent().getId().equals(event.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Ticket> getTicketsForEventAndDate(Event event, LocalDateTime date) {
        return ticketRepository.getAllTickets().stream()
                .filter(ticket -> ticket.getEvent().equals(event))
                .filter(ticket -> Math.abs(ChronoUnit.MINUTES.between(ticket.getDateTime(), date)) < 1)
                .collect(Collectors.toList());
    }

    @Override
    public List<Ticket> getPurchasedTicketsForEventAndDate(Event event, LocalDateTime date) {
        return ticketRepository.getAllTickets().stream()
                .filter(ticket -> ticket.getEvent().equals(event))
                .filter(ticket -> Math.abs(ChronoUnit.MINUTES.between(ticket.getDateTime(), date)) < 1)
                .filter(Ticket::isBooked)
                .collect(Collectors.toList());
    }

    @Override
    public List<Ticket> getFreeTicketsForEventAndDate(Event event, LocalDateTime date) {
        return ticketRepository.getAllTickets().stream()
                .filter(ticket -> ticket.getEvent().equals(event))
                .filter(ticket -> Math.abs(ChronoUnit.MINUTES.between(ticket.getDateTime(), date)) < 1)
                .filter(ticket -> !ticket.isBooked())
                .collect(Collectors.toList());
    }

    @Override
    public void bookTicketWithId(Long ticketId) {
        ticketRepository.bookTicketForUser(ticketRepository.getAllTickets().stream().filter(it ->ticketId.equals(it.getId())).findFirst().get(), 100L);
    }

    @Override
    public void bookTicketWithIdForUser(Long ticketId, Long userId) {
        ticketRepository.bookTicketForUser(ticketRepository.getAllTickets().stream().filter(it ->ticketId.equals(it.getId())).findFirst().get(), userId);
    }

    @Override
    public void unbookTicketWithId(Long ticketId, Long userId) {
        ticketRepository.unbookTicketForUser(ticketRepository.getAllTickets().stream().filter(it ->ticketId.equals(it.getId())).findFirst().get(), userId);
    }
    @Override
    public void buyTicket(Long ticketId){
        ticketRepository.buyTicket(ticketId);
    }

    @Override
    public List<Ticket> getTicketsForUser(Long id) {
        return ticketRepository.getTicketsForUser(id);
    }
}

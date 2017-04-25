package com.epam.cinema.controller.impl;

import com.epam.cinema.controller.TicketController;
import com.epam.cinema.model.Ticket;
import com.epam.cinema.service.EventService;
import com.epam.cinema.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController("/tickets")
public class TicketControllerImpl implements TicketController{
    @Autowired
    private TicketService ticketService;

    @Autowired
    private EventService eventService;

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public List<Ticket> getAllTickets() {
        List<Ticket> tickets = eventService.getAll().stream().map(event -> ticketService.getTicketsForEvent(event).stream()).flatMap(Function.identity()).collect(Collectors.toList());
        return tickets;
    }

}

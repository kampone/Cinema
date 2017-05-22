package com.epam.cinema.controller.impl;

import com.epam.cinema.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTicketBookController {

    @Autowired
    private TicketService ticketService;

    //TODO: change to PUT
    @RequestMapping(value = "/book/{id}/user/{userId}", method = RequestMethod.GET)
    public void bookTicket(@PathVariable Long id, @PathVariable Long userId) {
        ticketService.bookTicketWithIdForUser(id, userId);
    }

    @RequestMapping(value = "/events/{id}/user/{userId}", method = RequestMethod.GET)
    public Double getSumOfTickets(@PathVariable Long id, @PathVariable Long userId) {
        return ticketService.getTicketsForUser(userId)
                .stream()
                .filter(it -> it.getEvent().getId().equals(id))
                .mapToDouble(
                        ticket -> Double.parseDouble(ticket.getEvent().getBasePrice().toString())
                )
                .sum();
    }
}

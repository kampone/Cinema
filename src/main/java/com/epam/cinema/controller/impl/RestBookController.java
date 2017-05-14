package com.epam.cinema.controller.impl;

import com.epam.cinema.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestBookController {

    @Autowired
    private TicketService ticketService;

    @RequestMapping(value = "/book/{id}/user/{userId}", method = RequestMethod.GET)
    public HttpStatus bookTicket(@PathVariable Long id, @PathVariable Long userId) {
        ticketService.bookTicketWithIdForUser(id, userId);
        return HttpStatus.OK;
    }
}

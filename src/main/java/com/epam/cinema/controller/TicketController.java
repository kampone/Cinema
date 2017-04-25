package com.epam.cinema.controller;


import com.epam.cinema.model.Ticket;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface TicketController {
    List<Ticket> getAllTickets();
    HttpStatus bookTicket(Long id);
    HttpStatus unbookTicket(Long id);

}

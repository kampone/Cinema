package com.epam.cinema.service;

import com.epam.cinema.model.Event;
import com.epam.cinema.model.Ticket;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface TicketService {
    List<Ticket> getTicketsForEvent(Event event);
    List<Ticket> getTicketsForEventAndDate(Event event, LocalDateTime date);
    List<Ticket> getPurchaedTicketsForEventAndDate(Event event, LocalDateTime date);
    List<Ticket> getFreeTicketsForEventAndDate(Event event, LocalDateTime date);

}

package com.epam.cinema.controller.impl;

import com.epam.cinema.model.Event;
import com.epam.cinema.model.Seat;
import com.epam.cinema.model.Ticket;
import com.epam.cinema.service.BookingService;
import com.epam.cinema.service.EventService;
import com.epam.cinema.service.TicketService;
import com.epam.cinema.util.SeatComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
public class TicketControllerImpl {
    @Autowired
    private TicketService ticketService;

    @Autowired
    private EventService eventService;

    @Autowired
    private BookingService bookingService;
    @RequestMapping(value = "/tickets", method = RequestMethod.GET)
    public List<Ticket> getAllTickets() {
        List<Ticket> tickets = eventService.getAll().stream().map(event -> ticketService.getTicketsForEvent(event).stream()).flatMap(Function.identity()).collect(Collectors.toList());
        return tickets;
    }

    @RequestMapping(value = "events/{id}/tickets", method = RequestMethod.GET)
    public String getTicketsForEvent(@PathVariable Long id, Model model) {
        Event event = eventService.getById(id);
        if(event != null){
            model.addAttribute("event", event);
            List<Ticket> ticketsForEvent = ticketService.getTicketsForEvent(event);
            Integer places = ticketsForEvent.stream().map(Ticket::getSeat).map(Seat::getPlace).max(Integer::compareTo).get();
            Integer rows = ticketsForEvent.stream().map(Ticket::getSeat).map(Seat::getRow).max(Integer::compareTo).get();
            SeatComparator seatComparator = new SeatComparator();
            ticketsForEvent.sort((t1, t2) -> seatComparator.compare(t1.getSeat(), t2.getSeat()));
            model.addAttribute("tickets", ticketsForEvent);
            model.addAttribute("places", places);
            model.addAttribute("rows", rows);
        }
        return "event";
    }

    @RequestMapping(value = "tickets/{id}", method = RequestMethod.GET)
    public String getTicketInfo(@PathVariable Long id, Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        Ticket ticket = ticketService.getTicketsForUser(userId).stream().filter(it -> it.getId().equals(id)).findFirst().get();
        BigDecimal totalPrice = bookingService.getTicketsPrice(ticket.getEvent(), ticket.getDateTime(), ticket.getUser(), Arrays.asList(ticket.getSeat()));
        model.addAttribute("ticket", ticket);
        model.addAttribute("totalPrice", totalPrice);
        return "ticket";
    }

    @RequestMapping(value = "tickets/{id}/buy", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('admin')")
    public String buyTicket(@PathVariable Long id, Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        ticketService.buyTicket(id);
        return "redirect:/users/" + userId;
    }
}

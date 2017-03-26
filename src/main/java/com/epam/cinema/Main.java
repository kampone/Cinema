package com.epam.cinema;

import com.epam.cinema.model.*;
import com.epam.cinema.service.AuditoriumService;
import com.epam.cinema.service.BookingService;
import com.epam.cinema.service.EventService;
import com.epam.cinema.service.TicketService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        EventService eventService = context.getBean("eventService", EventService.class);
        TicketService ticketService = context.getBean("ticketService", TicketService.class);
        BookingService bookingService = context.getBean("bookingService", BookingService.class);
        AuditoriumService auditoriumService = context.getBean("auditoriumService", AuditoriumService.class);
        Auditorium starAuditorium = context.getBean("starAuditorium", Auditorium.class);
        addEvents(eventService);
        Event event = eventService.getById(1);
        List<Ticket> tickets = getTickets(ticketService, starAuditorium, event);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose ticket by id");
        System.out.println(tickets);

        int ticketId = scanner.nextInt();
        Ticket ticket = tickets.stream().filter(it -> it.getId().equals(ticketId)).findFirst().get();
        bookingService.bookTicket(ticket);
        System.out.println("Ticket is booked");




    }

    private static List<Ticket> getTickets(TicketService ticketService, Auditorium starAuditorium, Event event) {
        List<Ticket> ticketsForEvent = ticketService.getTicketsForEvent(event);
        int i = 0;
        for (Seat seat : starAuditorium.getSeats()) {
            ticketsForEvent.add(new Ticket(++i, event, LocalDateTime.of(2017,12,11,12,30),seat,null,false ));
        }
        return ticketsForEvent;
    }

    private static void addEvents(EventService eventService) {
        eventService.getAll().add(new Event(1,"Harry Potter", new BigDecimal(10), Rating.HIGH));
    }
}

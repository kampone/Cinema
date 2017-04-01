package com.epam.cinema;

import com.epam.cinema.configuration.SpringConfiguration;
import com.epam.cinema.model.*;
import com.epam.cinema.repository.impl.TicketRepositoryImpl;
import com.epam.cinema.service.BookingService;
import com.epam.cinema.service.EventService;
import com.epam.cinema.service.TicketService;
import com.epam.cinema.service.impl.TicketServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Main.class);
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        EventService eventService = context.getBean("eventService", EventService.class);
        TicketService ticketService = context.getBean("ticketService", TicketService.class);
        BookingService bookingService = context.getBean("bookingService", BookingService.class);
        Auditorium starAuditorium = context.getBean("starAuditorium", Auditorium.class);


        addEvents(eventService);
        Event event = eventService.getById(1);
        List<Ticket> tickets = getTickets(ticketService, starAuditorium, event);

        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("PURCHASED TICKETS:");
            System.out.println(ticketService.getPurchasedTicketsForEventAndDate(event, LocalDateTime.of(2017, 12, 11, 12, 30)));
            System.out.println("==============================================================");
            System.out.println("TICKETS TO BUY");
            System.out.println("Choose ticket by id");
            System.out.println(tickets);
            int ticketId = scanner.nextInt();

            Ticket ticket = tickets.stream().filter(it -> it.getId().equals(ticketId)).findFirst().get();
            bookingService.bookTicket(ticket);
            System.out.println("Ticket is booked");
            logger.info("=====================================================================");
        }
    }

    private static List<Ticket> getTickets(TicketService ticketService, Auditorium starAuditorium, Event event) {
        List<Ticket> ticketsForEvent =((TicketRepositoryImpl)((TicketServiceImpl) ticketService).getTicketRepository()).getTickets();
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

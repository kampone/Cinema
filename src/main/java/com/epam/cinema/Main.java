package com.epam.cinema;

import com.epam.cinema.configuration.SpringConfiguration;
import com.epam.cinema.model.Event;
import com.epam.cinema.model.Ticket;
import com.epam.cinema.model.User;
import com.epam.cinema.repository.AuditoriumRepository;
import com.epam.cinema.repository.EventRepository;
import com.epam.cinema.repository.TicketRepository;
import com.epam.cinema.repository.UserRepository;
import com.epam.cinema.service.DiscountService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class);


    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        AuditoriumRepository auditoriumRepository = context.getBean("auditoriumRepository", AuditoriumRepository.class);
        UserRepository userRepository = context.getBean("userRepository", UserRepository.class);
        EventRepository eventRepository = context.getBean("eventRepository", EventRepository.class);
        TicketRepository ticketRepository = context.getBean("ticketRepository", TicketRepository.class);
        DiscountService discountService = context.getBean("discountService", DiscountService.class);


        Event event = eventRepository.getEventByName("Harry Potter");
        eventRepository.getEventByName("Harry Potter");
        eventRepository.getEventByName("Harry Potter");
        eventRepository.getEventByName("Harry Potter");
        eventRepository.getEventByName("Harry Potter");
        User user = userRepository.getUserByEmail("Dzmitry@gmail.com");
        List<Ticket> tickets = ticketRepository.getTicketAll();
        discountService.getDiscount(user, event, LocalDateTime.now().plusDays(2),12);
        discountService.getDiscount(user, event, LocalDateTime.now().plusDays(2),1);

        tickets.forEach(ticket -> ticketRepository.bookTicketForUser(ticket, user.getId()));
    }

}

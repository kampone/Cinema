package com.epam.cinema.configuration;

import com.epam.cinema.model.Auditorium;
import com.epam.cinema.model.Event;
import com.epam.cinema.repository.EventRepository;
import com.epam.cinema.repository.TicketRepository;
import com.epam.cinema.repository.UserRepository;
import com.epam.cinema.service.*;
import com.epam.cinema.service.discount.DiscountStrategy;
import com.epam.cinema.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ServiceConfiguration {
    @Bean
    public UserService userService(@Autowired UserRepository repository){
        return new UserServiceImpl(repository);
    }

    @Bean
    public EventService eventService(@Autowired EventRepository repository){
        return new EventServiceImpl(repository);
    }

    @Bean
    public AuditoriumService auditoriumService(@Autowired List<Auditorium> auditoriums){
        AuditoriumServiceImpl auditoriumService = new AuditoriumServiceImpl();
        auditoriumService.setAuditoriums(auditoriums);
        return auditoriumService;
    }

    @Bean
    public DiscountService discountService(@Autowired List<DiscountStrategy> strategies){
        DiscountServiceImpl discountService = new DiscountServiceImpl();
        discountService.setStrategies(strategies);
        return discountService;
    }

    @Bean
    public TicketService ticketService(@Autowired TicketRepository repository){
        TicketServiceImpl ticketService = new TicketServiceImpl(repository);
        return ticketService;
    }

    @Bean
    public BookingService bookingService(@Autowired DiscountService discountService, @Autowired TicketService ticketService){
        BookingServiceImpl bookingService = new BookingServiceImpl();
        bookingService.setDiscountService(discountService);
        bookingService.setTicketService(ticketService);
        return bookingService;
    }
}

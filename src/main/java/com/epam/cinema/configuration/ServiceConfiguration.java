package com.epam.cinema.configuration;

import com.epam.cinema.repository.*;
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
    public UserService userService(@Autowired UserRepository repository, @Autowired AuthorityRepository authorityRepository){
        return new UserServiceImpl(repository, authorityRepository);
    }

    @Bean
    public EventService eventService(@Autowired EventRepository repository){
        return new EventServiceImpl(repository);
    }

    @Bean
    public AuditoriumService auditoriumService(@Autowired AuditoriumRepository auditoriumRepository){
        AuditoriumServiceImpl auditoriumService = new AuditoriumServiceImpl();
        auditoriumService.setAuditoriumRepository(auditoriumRepository);
        return auditoriumService;
    }

    @Bean
    public DiscountService discountService(@Autowired List<DiscountStrategy> strategies){
        DiscountServiceImpl discountService = new DiscountServiceImpl();
        discountService.setStrategies(strategies);
        return discountService;
    }

    @Bean
    public TicketService ticketService(@Autowired TicketRepository repository, @Autowired UserTicketsRepository userTicketsRepository){
        TicketServiceImpl ticketService = new TicketServiceImpl(repository, userTicketsRepository);
        return ticketService;
    }

    @Bean
    public BookingService bookingService(@Autowired DiscountService discountService, @Autowired TicketService ticketService, @Autowired UserTicketsRepository userTicketsRepository){
        BookingServiceImpl bookingService = new BookingServiceImpl();
        bookingService.setDiscountService(discountService);
        bookingService.setTicketService(ticketService);
        bookingService.setUserTicketsRepository(userTicketsRepository);
        return bookingService;
    }
}

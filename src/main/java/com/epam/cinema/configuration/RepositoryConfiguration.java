package com.epam.cinema.configuration;

import com.epam.cinema.handler.AuditoriumHandler;
import com.epam.cinema.model.Auditorium;
import com.epam.cinema.repository.BookingRepository;
import com.epam.cinema.repository.EventRepository;
import com.epam.cinema.repository.TicketRepository;
import com.epam.cinema.repository.UserRepository;
import com.epam.cinema.repository.impl.BookingRepositoryImpl;
import com.epam.cinema.repository.impl.EventRepositoryImpl;
import com.epam.cinema.repository.impl.TicketRepositoryImpl;
import com.epam.cinema.repository.impl.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
public class RepositoryConfiguration {
    @Bean
    public UserRepository userRepository(){
        return new UserRepositoryImpl();
    }

    @Bean
    public EventRepository eventRepository(){
        return new EventRepositoryImpl();
    }

    @Bean
    public TicketRepository ticketRepository(){
        return new TicketRepositoryImpl();
    }

    @Bean
    public BookingRepository bookingRepository(@Autowired JdbcTemplate jdbcTemplate){
        BookingRepositoryImpl repository = new BookingRepositoryImpl();
        repository.setJdbcTemplate(jdbcTemplate);
        return repository;
    }

}

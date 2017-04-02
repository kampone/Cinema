package com.epam.cinema.configuration;

import com.epam.cinema.repository.*;
import com.epam.cinema.repository.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

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

    @Bean SeatRepository seatRepository(){
        return new SeatRepositoryImpl();
    }
    @Bean
    public AuditoriumRepository auditoriumRepository(@Autowired JdbcTemplate jdbcTemplate, @Autowired SeatRepository seatRepository){
        AuditoriumRepositoryImpl repository = new AuditoriumRepositoryImpl();
        repository.setSeatRepository(seatRepository);
        repository.setJdbcTemplate(jdbcTemplate);
        return repository;
    }

}

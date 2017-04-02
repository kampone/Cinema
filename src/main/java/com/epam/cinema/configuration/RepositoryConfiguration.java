package com.epam.cinema.configuration;

import com.epam.cinema.repository.*;
import com.epam.cinema.repository.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.incrementer.H2SequenceMaxValueIncrementer;

@Configuration
public class RepositoryConfiguration {
    @Bean
    public UserRepository userRepository(@Autowired JdbcTemplate jdbcTemplate, @Autowired H2SequenceMaxValueIncrementer userIncrementer){
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        userRepository.setJdbcTemplate(jdbcTemplate);
        userRepository.setUserIncrementer(userIncrementer);
        return userRepository;
    }

    @Bean
    public EventRepository eventRepository(@Autowired JdbcTemplate jdbcTemplate, @Autowired H2SequenceMaxValueIncrementer eventIncrementer){
        EventRepositoryImpl eventRepository = new EventRepositoryImpl();
        eventRepository.setEventIncrementer(eventIncrementer);
        eventRepository.setJdbcTemplate(jdbcTemplate);
        return eventRepository;
    }

    @Bean
    public TicketRepository ticketRepository(
            @Autowired JdbcTemplate jdbcTemplate,
            @Autowired H2SequenceMaxValueIncrementer ticketIncrementer,
            @Autowired UserRepository userRepository,
            @Autowired EventRepository eventRepository,
            @Autowired SeatRepository seatRepository){

        TicketRepositoryImpl ticketRepository = new TicketRepositoryImpl();
        ticketRepository.setJdbcTemplate(jdbcTemplate);
        ticketRepository.setTicketIncrementer(ticketIncrementer);
        ticketRepository.setUserRepository(userRepository);
        ticketRepository.setEventRepository(eventRepository);
        ticketRepository.setSeatRepository(seatRepository);

        return ticketRepository;
    }

    @Bean SeatRepository seatRepository(@Autowired JdbcTemplate jdbcTemplate, @Autowired H2SequenceMaxValueIncrementer seatIncrementer){
        SeatRepositoryImpl seatRepository = new SeatRepositoryImpl();
        seatRepository.setJdbcTemplate(jdbcTemplate);
        seatRepository.setSeatIncrementer(seatIncrementer);
        return seatRepository;
    }
    @Bean
    public AuditoriumRepository auditoriumRepository(@Autowired JdbcTemplate jdbcTemplate, @Autowired SeatRepository seatRepository, @Autowired H2SequenceMaxValueIncrementer auditoriumIncrementer){
        AuditoriumRepositoryImpl repository = new AuditoriumRepositoryImpl();
        repository.setSeatRepository(seatRepository);
        repository.setJdbcTemplate(jdbcTemplate);
        repository.setAuditoriumIncrementer(auditoriumIncrementer);
        return repository;
    }

    @Bean
    public CounterRepository counterRepository(@Autowired JdbcTemplate jdbcTemplate){
        CounterRepositoryImpl counterRepository = new CounterRepositoryImpl();
        counterRepository.setJdbcTemplate(jdbcTemplate);
        return counterRepository;
    }

    @Bean
    public DiscountCounterRepository discountCounterRepository(@Autowired JdbcTemplate jdbcTemplate){
        DiscountCounterRepositoryImpl counterRepository = new DiscountCounterRepositoryImpl();
        counterRepository.setJdbcTemplate(jdbcTemplate);
        return counterRepository;
    }

}

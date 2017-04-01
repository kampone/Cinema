package com.epam.cinema.configuration;


import com.epam.cinema.handler.AuditoriumHandler;
import com.epam.cinema.model.Auditorium;
import com.epam.cinema.model.Event;
import com.epam.cinema.model.Ticket;
import com.epam.cinema.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
@ComponentScan({"com.epam.cinema.configuration", "com.epam.cinema.handler"})
public class SpringConfiguration {

    @Bean
    public Auditorium starAuditorium(@Autowired AuditoriumHandler handler){
        return handler.starAuditorium();
    }

    @Bean
    public Set<User> users(){
        return new HashSet<>();
    }

    @Bean
    public List<Event> events(){
        return new ArrayList<>();
    }

    @Bean
    public List<Ticket> tickets(){
        return new ArrayList<>();
    }
}

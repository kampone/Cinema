package com.epam.cinema;

import com.epam.cinema.configuration.SpringConfiguration;
import com.epam.cinema.model.Auditorium;
import com.epam.cinema.repository.AuditoriumRepository;
import com.epam.cinema.repository.EventRepository;
import com.epam.cinema.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class);


    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        AuditoriumRepository auditoriumRepository = context.getBean("auditoriumRepository", AuditoriumRepository.class);
        UserRepository userRepository = context.getBean("userRepository", UserRepository.class);
        EventRepository eventRepository = context.getBean("eventRepository", EventRepository.class);



    }

}

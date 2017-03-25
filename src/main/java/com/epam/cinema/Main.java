package com.epam.cinema;

import com.epam.cinema.handler.AuditoriumHandler;
import com.epam.cinema.model.Auditorium;
import com.epam.cinema.repository.BookingRepository;
import com.epam.cinema.repository.impl.BookingRepositoryImpl;
import com.epam.cinema.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        AuditoriumHandler handler = context.getBean("handler", AuditoriumHandler.class);
        BookingRepositoryImpl bookingRepository = context.getBean("bookingRepository", BookingRepositoryImpl.class);
        System.out.println(bookingRepository.getAuditoriums());
    }
}

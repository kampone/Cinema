package com.epam.cinema;

import com.epam.cinema.configuration.SpringConfiguration;
import com.epam.cinema.mapper.RatingMapper;
import com.epam.cinema.model.*;
import com.epam.cinema.repository.impl.TicketRepositoryImpl;
import com.epam.cinema.service.BookingService;
import com.epam.cinema.service.EventService;
import com.epam.cinema.service.TicketService;
import com.epam.cinema.service.impl.TicketServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class);


    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        System.out.println("www");
    }

}

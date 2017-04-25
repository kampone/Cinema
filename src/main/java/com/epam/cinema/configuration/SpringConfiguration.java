package com.epam.cinema.configuration;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan({"com.epam.cinema.configuration", "com.epam.cinema.util", "com.epam.cinema.controller"})
public class SpringConfiguration {

}

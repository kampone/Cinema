package com.epam.cinema.configuration;

import com.epam.cinema.service.discount.DiscountStrategy;
import com.epam.cinema.service.discount.impl.BirthdayDiscountStrategy;
import com.epam.cinema.service.discount.impl.MoreThanTenTicketsDiscountStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProdConfiguration {
    @Bean
    public DiscountStrategy birthdayDiscountStrategy(){
        return new BirthdayDiscountStrategy();
    }

    @Bean
    public DiscountStrategy tenTicketsDiscountStrategy(){
        return new MoreThanTenTicketsDiscountStrategy();
    }
}

package com.epam.cinema.configuration;

import com.epam.cinema.service.discount.DiscountStrategy;
import com.epam.cinema.service.discount.fakeImpl.FakeDiscountServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfiguration {
    @Bean
    public DiscountStrategy fakeDiscountStrategies(){
        return new FakeDiscountServiceImpl();
    }
}

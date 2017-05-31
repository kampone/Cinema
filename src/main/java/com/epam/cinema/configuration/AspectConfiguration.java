package com.epam.cinema.configuration;


import com.epam.cinema.aspect.CounterAspect;
import com.epam.cinema.aspect.DiscountCounterAspect;
import com.epam.cinema.repository.CounterRepository;
import com.epam.cinema.repository.DiscountCounterRepository;
import net.sourceforge.cobertura.CoverageIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@CoverageIgnore
public class AspectConfiguration {
    @Bean
    public CounterAspect counterAspect(@Autowired CounterRepository counterRepository){
        CounterAspect counterAspect = new CounterAspect();
        counterAspect.setCounterRepository(counterRepository);
        return counterAspect;
    }

    @Bean
    public DiscountCounterAspect discountCounterAspect(@Autowired DiscountCounterRepository discountCounterRepository){
        DiscountCounterAspect counterAspect = new DiscountCounterAspect();
        counterAspect.setDiscountCounterRepository(discountCounterRepository);
        return counterAspect;
    }
}

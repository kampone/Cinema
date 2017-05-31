package com.epam.cinema.aspect;

import com.epam.cinema.model.DiscountCounter;
import com.epam.cinema.model.Event;
import com.epam.cinema.model.User;
import com.epam.cinema.repository.DiscountCounterRepository;
import com.epam.cinema.service.discount.impl.BirthdayDiscountStrategy;
import com.epam.cinema.service.discount.impl.MoreThanTenTicketsDiscountStrategy;
import net.sourceforge.cobertura.CoverageIgnore;
import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import java.time.LocalDateTime;

@Aspect
@CoverageIgnore
public class DiscountCounterAspect {
    private DiscountCounterRepository discountCounterRepository;
    private final Logger log = Logger.getLogger(DiscountCounterAspect.class);

    public void setDiscountCounterRepository(DiscountCounterRepository discountCounterRepository) {
        this.discountCounterRepository = discountCounterRepository;
    }

    @AfterReturning(pointcut = "@annotation(com.epam.cinema.aspect.CountDiscountForUser) && args(user, event, dateTime, numberOfTickets)", returning = "result")
    public void countBookingTickets(User user, Event event, LocalDateTime dateTime, Integer numberOfTickets, Object result) {
        log.info("In DiscountCounterAspect");

        DiscountCounter counter = discountCounterRepository.getDiscountCounterByUserId(user.getId());
        if (counter != null) {
            if (MoreThanTenTicketsDiscountStrategy.DISCOUNT_SIZE.equals(result)) {
                counter.setTenTicketsStrategyCount(counter.getTenTicketsStrategyCount() + 1);
                discountCounterRepository.updateDiscountCounter(counter);
            }
            if (BirthdayDiscountStrategy.DISCOUNT_SIZE.equals(result)) {
                counter.setBirthdayStrategyCount(counter.getBirthdayStrategyCount() + 1);
                discountCounterRepository.updateDiscountCounter(counter);
            }
        } else {
            if (result.equals(MoreThanTenTicketsDiscountStrategy.DISCOUNT_SIZE)) {
                counter = new DiscountCounter(user.getId(), 0L, 1L);
            } else if (result.equals(BirthdayDiscountStrategy.DISCOUNT_SIZE)) {
                counter = new DiscountCounter(user.getId(), 1L, 0L);
            } else {
                counter =  new DiscountCounter(user.getId(), 0L, 0L);
            }
            discountCounterRepository.saveDiscountCounter(counter);
        }
    }
}

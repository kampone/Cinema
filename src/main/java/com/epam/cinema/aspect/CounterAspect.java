package com.epam.cinema.aspect;

import com.epam.cinema.model.Counter;
import com.epam.cinema.model.Ticket;
import com.epam.cinema.repository.CounterRepository;
import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class CounterAspect {
    private final Logger log = Logger.getLogger(CounterAspect.class);
    private CounterRepository counterRepository;

    public void setCounterRepository(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    @Before("@annotation(com.epam.cinema.aspect.CountEventName) && args(name)")
    public void countGetEventName(String name){
        log.info("In CounterAspect");

        Counter counter = counterRepository.getCounterByEventName(name);
        if (counter != null){
            counter.setNameInvocationCount(counter.getNameInvocationCount() + 1);
            counterRepository.updateCounter(counter);
        } else {
            counter = new Counter(name, 1L, 0L);
            counterRepository.saveCounter(counter);
        }
    }

    @Before("@annotation(com.epam.cinema.aspect.CountBookingTickets) && args(ticket, userId)")
    public void countBookingTickets(Ticket ticket, Long userId){
        log.info("In CounterAspect");

        String eventName = ticket.getEvent().getName();

        Counter counter = counterRepository.getCounterByEventName(eventName);
        if (counter != null){
            counter.setBookTicketCount(counter.getBookTicketCount() + 1);
            counterRepository.updateCounter(counter);
        } else {
            counter = new Counter(eventName, 0L, 1L);
            counterRepository.saveCounter(counter);
        }
    }
}

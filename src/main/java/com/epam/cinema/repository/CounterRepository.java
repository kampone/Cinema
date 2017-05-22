package com.epam.cinema.repository;


import com.epam.cinema.model.Counter;

public interface CounterRepository {
    Counter getCounterByEventName(String eventName);

    void updateCounter(Counter counter);

    void saveCounter(Counter counter);
}

package com.epam.cinema.repository;


import com.epam.cinema.model.Counter;

import java.util.List;

public interface CounterRepository {
    Counter getCounterByEventName(String eventName);

    List<Counter> getAllCounters();

    void updateCounter(Counter counter);

    void saveCounter(Counter counter);
}

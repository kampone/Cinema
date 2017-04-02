package com.epam.cinema.repository;


import com.epam.cinema.model.DiscountCounter;

import java.util.List;

public interface DiscountCounterRepository {
    DiscountCounter getCounterByUserId(Long userId);

    List<DiscountCounter> getAllCounters();

    void update(DiscountCounter counter);

    void save(DiscountCounter counter);
}

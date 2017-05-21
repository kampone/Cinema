package com.epam.cinema.repository;


import com.epam.cinema.model.DiscountCounter;

import java.util.List;

public interface DiscountCounterRepository {
    DiscountCounter getDiscountCounterByUserId(Long userId);

    List<DiscountCounter> getAllDiscountCounters();

    void updateDiscountCounter(DiscountCounter counter);

    void saveDiscountCounter(DiscountCounter counter);
}

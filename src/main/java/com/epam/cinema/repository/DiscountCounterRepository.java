package com.epam.cinema.repository;


import com.epam.cinema.model.DiscountCounter;

public interface DiscountCounterRepository {
    DiscountCounter getDiscountCounterByUserId(Long userId);

    void updateDiscountCounter(DiscountCounter counter);

    void saveDiscountCounter(DiscountCounter counter);
}

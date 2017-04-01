package com.epam.cinema.repository;

import com.epam.cinema.model.Auditorium;

import java.util.List;

public interface BookingRepository {
    /**
     * Return all auditoriums
     * @return All auditoriums
     */
    List<Auditorium> getAll();

    Auditorium findById(Long id);

    Auditorium findByName(String name);

    void save(Auditorium auditorium);

    void remove(Auditorium auditorium);

    void update(Auditorium auditorium);
}

package com.epam.cinema.service;

import com.epam.cinema.model.Auditorium;

import java.util.List;

/**
 * Returns info about auditoriums and places
 */
public interface AuditoriumService {
    /**
     * Return all auditoriums
     *
     * @return all auditoriums
     */
    List<Auditorium> getAll();

    /**
     * Find auditorium by name. Return null if no auditorium with such name
     *
     * @param name Auditorium's name
     * @return auditorium
     */
    Auditorium getByName(String name);
}

package com.epam.cinema.repository;

import com.epam.cinema.model.Auditorium;

import java.util.List;

public interface AuditoriumRepository {
    /**
     * Return all auditoriums
     * @return All auditoriums
     */
    List<Auditorium> getAllAuditoriums();

    Auditorium findAuditoriumById(Long id);

    Auditorium findAuditoriumByName(String name);

    void saveAuditorium(Auditorium auditorium);

    void removeAuditorium(Auditorium auditorium);

    void updateAuditorium(Auditorium auditorium);
}

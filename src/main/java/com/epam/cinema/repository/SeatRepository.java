package com.epam.cinema.repository;


import com.epam.cinema.model.Seat;

import java.util.List;

public interface SeatRepository {

    void saveToAuditorium(Seat seat, Long auditoriumId);

    Seat getById(Long id);

    List<Seat> getByAuditoriumId(Long id);

    void removeSeatsFromAuditorium(Long auditoriumId);
}

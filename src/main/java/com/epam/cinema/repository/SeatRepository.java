package com.epam.cinema.repository;


import com.epam.cinema.model.Seat;

import java.util.List;

public interface SeatRepository {

    void saveSeatToAuditorium(Seat seat, Long auditoriumId);

    Seat getSeatById(Long id);

    List<Seat> getSeatsByAuditoriumId(Long id);

    void removeSeatsFromAuditorium(Long auditoriumId);
}

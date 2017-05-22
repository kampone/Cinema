package com.epam.cinema.repository.jpaimpl;

import com.epam.cinema.model.Auditorium;
import com.epam.cinema.model.Seat;
import com.epam.cinema.repository.SeatRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
@Profile("jpa")
public class SeatRepositoryImpl implements SeatRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveSeatToAuditorium(Seat seat, Long auditoriumId) {

    }

    @Override
    public Seat getSeatById(Long id) {
        return entityManager.find(Seat.class, id);
    }

    @Override
    public List<Seat> getSeatsByAuditoriumId(Long id) {
        return entityManager.createQuery("select s from Seat s Join s.auditorium a where a.id = :id", Seat.class).setParameter("id", id).getResultList();
    }

    @Override
    public void removeSeatsFromAuditorium(Long auditoriumId) {
        entityManager.find(Auditorium.class, auditoriumId).setSeats(null);
    }
}

package com.epam.cinema.repository.impl;

import com.epam.cinema.model.Seat;
import com.epam.cinema.repository.SeatRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


public class SeatRepositoryImpl implements SeatRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveToAuditorium(Seat seat, Long auditoriumId) {
        jdbcTemplate.update("INSERT INTO SEATS()");
    }

    @Override
    public Seat getById(Long id) {
        return null;
    }

    @Override
    public List<Seat> getByAuditoriumId(Long id) {
        return null;
    }

    @Override
    public void removeSeatsFromAuditorium(Long auditoriumId) {

    }
}

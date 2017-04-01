package com.epam.cinema.repository.impl;

import com.epam.cinema.model.Auditorium;
import com.epam.cinema.repository.BookingRepository;
import com.epam.cinema.repository.SeatRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.util.List;

public class BookingRepositoryImpl implements BookingRepository {

    private static final String GET_ALL_QUERY = "SELECT auditorium.id, auditorium.name FROM AUDITORIUM auditorium";
    private static final String GET_BY_ID_QUERY = "SELECT auditorium.id, auditorium.name FROM AUDITORIUM auditorium WHERE auditorium.id = ?";
    private static final String GET_BY_ID_NAME = "SELECT auditorium.id, auditorium.name FROM AUDITORIUM auditorium WHERE auditorium.name = ?";
    private static final String INSERT_USER = "INSERT INTO USERS (id, name) VALUES (user_sequence, ?)";
    private static final String DELETE_SEATS = "DELETE FROM SEATS WHERE AUDITORIUM_ID = ?";
    private static final String DELETE_AUDITORIUM = "DELETE FROM AUDITORIUMS WHERE ID = ?";
    private static final String UPDATE_AUDITORIUM = "UPDATE AUDITORIUMS SET NAME = ? WHERE ID = ?";

    private JdbcTemplate jdbcTemplate;
    private SeatRepository repository;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public SeatRepository getRepository() {
        return repository;
    }

    public void setRepository(SeatRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Auditorium> getAll() {
        return jdbcTemplate.query(GET_ALL_QUERY, ((resultSet, i) ->
                new Auditorium(resultSet.getLong(1), resultSet.getString(2), null))
        );
    }

    @Override
    public Auditorium findById(Long id) {
        return jdbcTemplate.queryForObject(GET_BY_ID_QUERY, new Object[]{id}, ((resultSet, i) ->
                new Auditorium(resultSet.getLong(1), resultSet.getString(2), null))
        );
    }

    @Override
    public Auditorium findByName(String name) {
        return jdbcTemplate.queryForObject(GET_BY_ID_NAME, new Object[]{name}, ((resultSet, i) ->
                new Auditorium(resultSet.getLong(1), resultSet.getString(2), null))
        );
    }

    @Override
    public void save(Auditorium auditorium) {
        jdbcTemplate.update(INSERT_USER, auditorium.getName());
    }

    @Override
    public void remove(Auditorium auditorium) {
        jdbcTemplate.update(DELETE_SEATS, auditorium.getId());
        jdbcTemplate.update(DELETE_AUDITORIUM, auditorium.getId());
    }

    @Override
    public void update(Auditorium auditorium) {
        jdbcTemplate.update(UPDATE_AUDITORIUM, auditorium.getName(), auditorium.getId());
    }
}

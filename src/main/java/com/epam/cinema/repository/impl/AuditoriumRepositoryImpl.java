package com.epam.cinema.repository.impl;


import com.epam.cinema.model.Auditorium;
import com.epam.cinema.repository.AuditoriumRepository;
import com.epam.cinema.repository.SeatRepository;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AuditoriumRepositoryImpl implements AuditoriumRepository {

    private static final String GET_ALL_QUERY = "SELECT auditorium.id, auditorium.name FROM AUDITORIUMS auditorium";
    private static final String GET_BY_ID_QUERY = "SELECT auditorium.id, auditorium.name FROM AUDITORIUMS auditorium WHERE auditorium.id = ?";
    private static final String GET_BY_ID_NAME = "SELECT auditorium.id, auditorium.name FROM AUDITORIUMS auditorium WHERE auditorium.name = ?";
    private static final String INSERT_AUDITORIUM = "INSERT INTO AUDITORIUMS (id, name) VALUES (user_sequence.nextval, ?)";
    private static final String DELETE_SEATS = "DELETE FROM SEATS WHERE AUDITORIUM_ID = ?";
    private static final String DELETE_AUDITORIUM = "DELETE FROM AUDITORIUMS WHERE ID = ?";
    private static final String UPDATE_AUDITORIUM = "UPDATE AUDITORIUMS SET NAME = ? WHERE ID = ?";

    private JdbcTemplate jdbcTemplate;
    private SeatRepository seatRepository;

    private final Logger log = Logger.getLogger(AuditoriumRepositoryImpl.class);

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public SeatRepository getSeatRepository() {
        return seatRepository;
    }

    public void setSeatRepository(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Override
    public List<Auditorium> getAll() {
        return jdbcTemplate.query(GET_ALL_QUERY, ((resultSet, i) ->
                new Auditorium(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        seatRepository.getByAuditoriumId(resultSet.getLong(1))
                ))
        );
    }

    @Override
    public Auditorium findById(Long id) {
        return jdbcTemplate.queryForObject(GET_BY_ID_QUERY, new Object[]{id}, ((resultSet, i) ->
                new Auditorium(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        seatRepository.getByAuditoriumId(resultSet.getLong(1))
                ))
        );
    }

    @Override
    public Auditorium findByName(String name) {
        return jdbcTemplate.queryForObject(GET_BY_ID_NAME, new Object[]{name}, ((resultSet, i) ->
                new Auditorium(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        seatRepository.getByAuditoriumId(resultSet.getLong(1))
                ))
        );
    }

    @Override
    public void save(Auditorium auditorium) {
        int update = jdbcTemplate.update(INSERT_AUDITORIUM, auditorium.getName());
        log.info("FROM UPDATE: " + update);
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

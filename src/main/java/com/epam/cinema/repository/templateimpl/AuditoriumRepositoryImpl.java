package com.epam.cinema.repository.templateimpl;


import com.epam.cinema.model.Auditorium;
import com.epam.cinema.repository.AuditoriumRepository;
import com.epam.cinema.repository.SeatRepository;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.incrementer.H2SequenceMaxValueIncrementer;

import java.util.List;

public class AuditoriumRepositoryImpl implements AuditoriumRepository {

    private static final String GET_ALL_QUERY = "SELECT auditorium.id, auditorium.name FROM AUDITORIUMS auditorium";
    private static final String GET_BY_ID_QUERY = "SELECT auditorium.id, auditorium.name FROM AUDITORIUMS auditorium WHERE auditorium.id = ?";
    private static final String GET_BY_ID_NAME = "SELECT auditorium.id, auditorium.name FROM AUDITORIUMS auditorium WHERE auditorium.name = ?";
    private static final String INSERT_AUDITORIUM = "INSERT INTO AUDITORIUMS (id, name) VALUES (?, ?)";
    private static final String DELETE_AUDITORIUM = "DELETE FROM AUDITORIUMS WHERE ID = ?";
    private static final String UPDATE_AUDITORIUM = "UPDATE AUDITORIUMS SET NAME = ? WHERE ID = ?";

    private JdbcTemplate jdbcTemplate;
    private SeatRepository seatRepository;
    private H2SequenceMaxValueIncrementer auditoriumIncrementer;

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

    public void setAuditoriumIncrementer(H2SequenceMaxValueIncrementer auditoriumIncrementer) {
        this.auditoriumIncrementer = auditoriumIncrementer;
    }

    @Override
    public List<Auditorium> getAllAuditoriums() {
        log.debug("Retrieving all auditoriums");
        List<Auditorium> auditoriums = jdbcTemplate.query(GET_ALL_QUERY, ((resultSet, i) ->
                new Auditorium(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        seatRepository.getSeatsByAuditoriumId(resultSet.getLong(1))
                ))
        );

        auditoriums.forEach(auditorium -> auditorium.setSeats(seatRepository.getSeatsByAuditoriumId(auditorium.getId())));
        return auditoriums;
    }

    @Override
    public Auditorium findAuditoriumByName(String name) {
        log.debug("Retrieving auditorium by name: " + name);

        return jdbcTemplate.queryForObject(GET_BY_ID_NAME, new Object[]{name}, ((resultSet, i) ->
                new Auditorium(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        seatRepository.getSeatsByAuditoriumId(resultSet.getLong(1))
                ))
        );
    }

    @Override
    public void saveAuditorium(Auditorium auditorium) {

        log.debug("Save auditorium: " + auditorium.getName());

        long id = auditoriumIncrementer.nextLongValue();
        auditorium.setId(id);
        jdbcTemplate.update(INSERT_AUDITORIUM, id, auditorium.getName());
        auditorium.getSeats().forEach(seat -> seatRepository.saveSeatToAuditorium(seat, auditorium.getId()));
    }
}

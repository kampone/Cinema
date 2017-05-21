package com.epam.cinema.repository.impl;

import com.epam.cinema.model.Seat;
import com.epam.cinema.repository.SeatRepository;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.incrementer.H2SequenceMaxValueIncrementer;

import java.util.List;


public class SeatRepositoryImpl implements SeatRepository {

    private static final String INSERT_SEAT = "INSERT INTO SEATS(ID, ROW, PLACE, VIP, AUDITORIUM_ID) VALUES (?, ?, ?, ?, ?)";
    private static final String GET_BY_ID = "SELECT seat.id, seat.row, seat.place, seat.vip FROM SEATS seat WHERE seat.id = ?";
    private static final String GET_BY_AUDITORIUM_ID = "SELECT seat.ID, seat.ROW, seat.PLACE, seat.VIP FROM SEATS seat WHERE seat.AUDITORIUM_ID = ?";
    private static final String DELETE_SEATS = "DELETE FROM SEATS WHERE AUDITORIUM_ID = ?";

    private JdbcTemplate jdbcTemplate;
    private H2SequenceMaxValueIncrementer seatIncrementer;

    private final Logger log = Logger.getLogger(SeatRepositoryImpl.class);

    public void setSeatIncrementer(H2SequenceMaxValueIncrementer seatIncrementer) {
        this.seatIncrementer = seatIncrementer;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveSeatToAuditorium(Seat seat, Long auditoriumId) {
        log.debug("Saving seat o auditorium with id " + auditoriumId);
        long id = seatIncrementer.nextLongValue();
        seat.setId(id);
        jdbcTemplate.update(INSERT_SEAT, id, seat.getRow(), seat.getPlace(), seat.isVip(), auditoriumId);
    }

    @Override
    public Seat getSeatById(Long id) {
        log.debug("Retrieving seat by id");

        return jdbcTemplate.queryForObject(GET_BY_ID,
                new Object[]{id},
                ((resultSet, i) -> new Seat(
                        resultSet.getLong(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getBoolean(4)
                ))
        );
    }

    @Override
    public List<Seat> getSeatsByAuditoriumId(Long id) {
        log.debug("Retrieving seat by auditorium id+ " + id);

        return jdbcTemplate.query(GET_BY_AUDITORIUM_ID,
                new Object[]{id},
                ((resultSet, i) -> new Seat(
                        resultSet.getLong(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getBoolean(4)
                ))
        );
    }

    @Override
    public void removeSeatsFromAuditorium(Long auditoriumId) {
        log.debug("Removing seat : " + auditoriumId);

        jdbcTemplate.update(DELETE_SEATS, auditoriumId);
    }
}

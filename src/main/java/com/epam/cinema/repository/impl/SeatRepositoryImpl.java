package com.epam.cinema.repository.impl;

import com.epam.cinema.model.Seat;
import com.epam.cinema.repository.SeatRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.incrementer.H2SequenceMaxValueIncrementer;

import java.util.List;


public class SeatRepositoryImpl implements SeatRepository {

    private static final String INSERT_SEAT = "INSERT INTO SEATS(ID, ROW, PLACE, VIP, AUDITORIUM_ID) VALUES (?, ?, ?, ?, ?)";
    private static final String GET_BY_ID = "SELECT seat.id, seat.row, seat.place, seat.vip FROM SEATS seat WHERE seat.id = ?";
    private static final String GET_BY_AUDITORIUM_ID = "SELECT seat.ID, seat.ROW, seat.PLACE, seat.VIP FROM SEATS seat WHERE seat.AUDITORIUM_ID = ?";
    private static final String DELETE_SEATS = "DELETE FROM SEATS WHERE AUDITORIUM_ID = ?";

    private JdbcTemplate jdbcTemplate;
    private H2SequenceMaxValueIncrementer seatIncrementor;

    public void setSeatIncrementor(H2SequenceMaxValueIncrementer seatIncrementor) {
        this.seatIncrementor = seatIncrementor;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveToAuditorium(Seat seat, Long auditoriumId) {
        long id = seatIncrementor.nextLongValue();
        seat.setId(id);
        jdbcTemplate.update(INSERT_SEAT, id, seat.getRow(), seat.getPlace(), seat.isVip(), auditoriumId);
    }

    @Override
    public Seat getById(Long id) {
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
    public List<Seat> getByAuditoriumId(Long id) {
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
        jdbcTemplate.update(DELETE_SEATS, auditoriumId);
    }
}

package com.epam.cinema.repository.impl;

import com.epam.cinema.model.Event;
import com.epam.cinema.model.Rating;
import com.epam.cinema.repository.EventRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.incrementer.H2SequenceMaxValueIncrementer;

import java.util.List;

public class EventRepositoryImpl implements EventRepository{

    private static final String INSERT_EVENT = "INSERT INTO EVENTS(ID, NAME, BASE_PRICE, RATING_ID) VALUES (?, ? ,? ,?)";
    private static final String GET_BY_ID = "SELECT event.ID, event.NAME, event.BASE_PRICE, event.RATING_ID FROM EVENTS event WHERE event.id = ?";
    private static final String GET_BY_NAME = "SELECT event.ID, event.NAME, event.BASE_PRICE, event.RATING_ID FROM EVENTS event WHERE event.NAME = ?";
    private static final String GET_ALL = "SELECT event.ID, event.NAME, event.BASE_PRICE, event.RATING_ID FROM EVENTS event";
    private JdbcTemplate jdbcTemplate;
    private H2SequenceMaxValueIncrementer eventIncrementer;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setEventIncrementer(H2SequenceMaxValueIncrementer eventIncrementer) {
        this.eventIncrementer = eventIncrementer;
    }

    @Override
    public void save(Event event) {
        long id = eventIncrementer.nextLongValue();
        jdbcTemplate.update(INSERT_EVENT, id, event.getName(), event.getBasePrice(), event.getRating().ordinal());
    }

    @Override
    public void remove(Event event) {
        jdbcTemplate.update("DELETE FROM EVENTS WHERE ID = ?", event.getId());
    }

    @Override
    public Event getById(Integer id) {
        return jdbcTemplate.queryForObject(GET_BY_ID, new Object[]{id},
                (resultSet, i) -> new Event(resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getBigDecimal(3),
                        Rating.values()[resultSet.getInt(4)])
        );
    }

    @Override
    public Event getByName(String name) {
        return jdbcTemplate.queryForObject(GET_BY_NAME, new Object[]{name},
                (resultSet, i) -> new Event(resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getBigDecimal(3),
                        Rating.values()[resultSet.getInt(4)])
        );
    }

    @Override
    public List<Event> getAll() {
        return jdbcTemplate.query(GET_ALL,
                (resultSet, i) -> new Event(resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getBigDecimal(3),
                        Rating.values()[resultSet.getInt(4)])
        );
    }
}

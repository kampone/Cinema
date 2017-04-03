package com.epam.cinema.repository.impl;


import com.epam.cinema.model.Counter;
import com.epam.cinema.repository.CounterRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CounterRepositoryImpl implements CounterRepository {

    private static final String GET_BY_EVENT_NAME = "SELECT event_name, get_name_count, book_ticket_count FROM COUNTERS WHERE event_name = ?";
    private static final String GET_ALL = "SELECT event_name, get_name_count, book_ticket_count FROM COUNTERS";
    private static final String UPDATE_COUNTER = "UPDATE COUNTERS SET get_name_count = ?, book_ticket_count = ? WHERE event_name = ?";
    private static final String INSERT_COUNTER = "INSERT INTO COUNTERS(event_name, get_name_count, book_ticket_count) VALUES (?, ?, ?)";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Counter getCounterByEventName(String eventName) {
        try {
            return jdbcTemplate.queryForObject(GET_BY_EVENT_NAME, new Object[]{eventName}, (resultSet, i) ->
                    new Counter(resultSet.getString(1), resultSet.getLong(2), resultSet.getLong(3))
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Counter> getAllCounters() {
        return jdbcTemplate.query(GET_ALL, (resultSet, i) ->
                new Counter(resultSet.getString(1), resultSet.getLong(2), resultSet.getLong(3))
        );
    }

    @Override
    public void update(Counter counter) {
        jdbcTemplate.update(UPDATE_COUNTER, counter.getNameInvocationCount(), counter.getBookTicketCount(), counter.getEventName());
    }

    @Override
    public void save(Counter counter) {
        jdbcTemplate.update(INSERT_COUNTER, counter.getEventName(), counter.getNameInvocationCount(), counter.getBookTicketCount());
    }
}

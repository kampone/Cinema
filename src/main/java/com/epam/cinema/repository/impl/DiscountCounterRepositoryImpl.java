package com.epam.cinema.repository.impl;

import com.epam.cinema.model.DiscountCounter;
import com.epam.cinema.repository.DiscountCounterRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


public class DiscountCounterRepositoryImpl implements DiscountCounterRepository {

    private static final String GET_BY_USER_ID = "SELECT user_id, birthday_strategy_count, ten_tickets_strategy_count FROM DISCOUNT_COUNTERS WHERE user_id = ?";
    private static final String GET_ALL = "SELECT user_id, birthday_strategy_count, ten_tickets_strategy_count FROM DISCOUNT_COUNTERS";
    private static final String UPDATE_COUNTER = "UPDATE DISCOUNT_COUNTERS SET birthday_strategy_count = ?, ten_tickets_strategy_count = ? WHERE user_id = ?";
    private static final String INSERT_COUNTER = "INSERT INTO DISCOUNT_COUNTERS(user_id, birthday_strategy_count, ten_tickets_strategy_count) VALUES (?, ?, ?)";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public DiscountCounter getDiscountCounterByUserId(Long userId) {
        try {
            return jdbcTemplate.queryForObject(GET_BY_USER_ID, new Object[]{userId}, (resultSet, i) ->
                    new DiscountCounter(resultSet.getLong(1), resultSet.getLong(2), resultSet.getLong(3))
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<DiscountCounter> getAllDiscountCounters() {
        return jdbcTemplate.query(GET_ALL, (resultSet, i) ->
                new DiscountCounter(resultSet.getLong(1), resultSet.getLong(2), resultSet.getLong(3))
        );
    }

    @Override
    public void updateDiscountCounter(DiscountCounter counter) {
        jdbcTemplate.update(UPDATE_COUNTER, counter.getBirthdayStrategyCount(), counter.getTenTicketsStrategyCount(), counter.getUserId());
    }

    @Override
    public void saveDiscountCounter(DiscountCounter counter) {
        jdbcTemplate.update(INSERT_COUNTER, counter.getUserId(), counter.getBirthdayStrategyCount(), counter.getTenTicketsStrategyCount());
    }
}

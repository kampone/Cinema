package com.epam.cinema.repository.impl;

import com.epam.cinema.model.User;
import com.epam.cinema.repository.TicketRepository;
import com.epam.cinema.repository.UserRepository;
import com.epam.cinema.service.TicketService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.incrementer.H2SequenceMaxValueIncrementer;

import javax.annotation.Resource;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserRepositoryImpl implements UserRepository {

    private static final String INSERT_USER = "INSERT INTO USERS (id, name, email, birthday) VALUES (?, ?, ?, ?)";
    private static final String GET_BY_ID = "SELECT user.ID, user.NAME, user.EMAIL, user.BIRTHDAY FROM USERS user WHERE user.ID = ?";
    private static final String GET_BY_NAME = "SELECT user.ID, user.NAME, user.EMAIL, user.BIRTHDAY FROM USERS user WHERE user.EMAIL = ?";
    private static final String GET_ALL = "SELECT user.ID, user.NAME, user.EMAIL, user.BIRTHDAY FROM USERS user";
    private JdbcTemplate jdbcTemplate;
    private H2SequenceMaxValueIncrementer userIncrementer;
    private TicketRepository ticketRepository;


    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setUserIncrementer(H2SequenceMaxValueIncrementer userIncrementer) {
        this.userIncrementer = userIncrementer;
    }

    public void setTicketRepository(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public void save(User user) {
        long id = userIncrementer.nextLongValue();
        jdbcTemplate.update(INSERT_USER, id, user.getName(), user.getEmail(), Date.valueOf(user.getBirthDate()));
    }

    @Override
    public void remove(User user) {
        jdbcTemplate.update("DELETE FROM USERS WHERE ID = ?", user.getId());
    }

    @Override
    public User getById(Long id) {
        User user = jdbcTemplate.queryForObject(GET_BY_ID, new Object[]{id},
                ((resultSet, i) -> new User(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(4).toLocalDate(),
                        null
                )));
        user.setTickets(ticketRepository.getTicketsForUser(id));
        return user;
    }

    @Override
    public User getByEmail(String email) {
        User user = jdbcTemplate.queryForObject(GET_BY_NAME, new Object[]{email},
                ((resultSet, i) -> new User(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(4).toLocalDate(),
                        null
                )));
        user.setTickets(ticketRepository.getTicketsForUser(user.getId()));
        return user;
    }

    @Override
    public Set<User> getAll() {
        List<User> users = jdbcTemplate.query(GET_ALL,
                ((resultSet, i) -> new User(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(4).toLocalDate(),
                        null
                )));
        users.forEach(it -> it.setTickets(ticketRepository.getTicketsForUser(it.getId())));
        return new HashSet<>(users);
    }
}

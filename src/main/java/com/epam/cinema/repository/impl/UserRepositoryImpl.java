package com.epam.cinema.repository.impl;

import com.epam.cinema.model.User;
import com.epam.cinema.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.incrementer.H2SequenceMaxValueIncrementer;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserRepositoryImpl implements UserRepository {

    private static final String INSERT_USER = "INSERT INTO USERS (id, USERNAME, email, birthday, password, enabled) VALUES (?, ?, ?, ?, ?, true)";
    private static final String GET_BY_ID = "SELECT user.ID, user.USERNAME, user.EMAIL, user.BIRTHDAY FROM USERS user WHERE user.ID = ?";
    private static final String GET_BY_NAME = "SELECT user.ID, user.USERNAME, user.EMAIL, user.BIRTHDAY FROM USERS user WHERE user.EMAIL = ?";
    private static final String GET_ALL = "SELECT user.ID, user.USERNAME, user.EMAIL, user.BIRTHDAY FROM USERS user";
    private static final String DELETE_USER = "DELETE FROM USERNAME WHERE ID = ?";
    private JdbcTemplate jdbcTemplate;
    private H2SequenceMaxValueIncrementer userIncrementer;

    private final Logger log = Logger.getLogger(UserRepositoryImpl.class);

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setUserIncrementer(H2SequenceMaxValueIncrementer userIncrementer) {
        this.userIncrementer = userIncrementer;
    }

    @Override
    public void saveUser(User user) {
        log.debug("Saving user:" + user.getName());
        long id = userIncrementer.nextLongValue();
        jdbcTemplate.update(INSERT_USER, id, user.getName(), user.getEmail(), Date.valueOf(user.getBirthDate()), user.getPassword());
    }

    @Override
    public void removeUser(User user) {
        log.debug("Removing user : " + user.getId());

        jdbcTemplate.update(DELETE_USER, user.getId());
    }

    @Override
    public User getUserById(Long id) {
        log.debug("Retrieving user by id: " + id);


        try {
            return jdbcTemplate.queryForObject(GET_BY_ID, new Object[]{id},
                    ((resultSet, i) -> new User(
                            resultSet.getLong(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getDate(4).toLocalDate(),
                            null
                    )));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public User getUserByEmail(String email) {
        log.debug("Retrieving user by email:" + email);
        try {


            return jdbcTemplate.queryForObject(GET_BY_NAME, new Object[]{email},
                    ((resultSet, i) -> new User(
                            resultSet.getLong(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getDate(4).toLocalDate(),
                            null
                    )));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Set<User> getAllUser() {
        log.debug("Retrieving all users");

        List<User> users = jdbcTemplate.query(GET_ALL,
                ((resultSet, i) -> new User(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(4).toLocalDate(),
                        null
                )));
        return new HashSet<>(users);
    }
}

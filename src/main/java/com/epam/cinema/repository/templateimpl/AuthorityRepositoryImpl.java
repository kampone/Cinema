package com.epam.cinema.repository.templateimpl;


import com.epam.cinema.repository.AuthorityRepository;
import org.springframework.jdbc.core.JdbcTemplate;

public class AuthorityRepositoryImpl implements AuthorityRepository{

    private JdbcTemplate jdbcTemplate;
    private static final String INSERT_AUTHORITY = "insert into authorities(username,authority)  VALUES (?, 'user')";
    private static final String GET_AUTHORITY = "SELECT authority FROM authorities WHERE username = ?";


    @Override
    public void assignUser(String username) {
        jdbcTemplate.update(INSERT_AUTHORITY, username);
    }

    @Override
    public String getAuthority(String username) {
        return jdbcTemplate.queryForObject(GET_AUTHORITY, new Object[]{username}, (resultSet, i) -> resultSet.getString(1));
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}

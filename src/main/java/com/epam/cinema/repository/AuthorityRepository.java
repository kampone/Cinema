package com.epam.cinema.repository;

import org.springframework.jdbc.core.JdbcTemplate;

public interface AuthorityRepository {

    void assignUser(String username);

    String getAuthority(String username);
}

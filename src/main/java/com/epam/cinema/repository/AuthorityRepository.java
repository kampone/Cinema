package com.epam.cinema.repository;

public interface AuthorityRepository {

    void assignUser(String username);

    String getAuthority(String username);
}

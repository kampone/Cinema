package com.epam.cinema.repository.jpaimpl;

import com.epam.cinema.repository.AuthorityRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
@Profile("jpa")
public class AuthorityRepositoryImpl implements AuthorityRepository {
    private static final String INSERT_AUTHORITY = "insert into authorities(username,authority) VALUES (?, 'user')";
    private static final String GET_AUTHORITY = "SELECT authority FROM authorities WHERE username = ";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void assignUser(String username) {
        entityManager.createNativeQuery(INSERT_AUTHORITY).setParameter(1, username).executeUpdate();
    }

    @Override
    public String getAuthority(String username) {
        return entityManager.createNativeQuery(GET_AUTHORITY + "'" +username+ "'").getSingleResult().toString();
    }
}

package com.epam.cinema.repository;

import com.epam.cinema.model.User;

import java.util.Set;

public interface UserRepository {
    /**
     * Create new user
     *
     * @param user entity should be persisted
     */
    void saveUser(User user);

    /**
     * Remove user
     *
     * @param user entity should be deleted
     */
    void removeUser(User user);

    /**
     * Find user by id. Return null if no user with such id
     *
     * @param id User's Id
     * @return User with specified id
     */
    User getUserById(Long id);

    /**
     * Find user by email. Return null if no user with such email
     *
     * @param email User's email
     * @return User with specified email
     */
    User getUserByEmail(String email);

    /**
     * Find all persisted users
     *
     * @return all users
     */
    Set<User> getAllUser();
}

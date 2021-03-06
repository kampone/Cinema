package com.epam.cinema.service.impl;

import com.epam.cinema.model.User;
import com.epam.cinema.repository.UserRepository;
import com.epam.cinema.service.UserService;

import java.util.Set;

public class UserServiceImpl implements UserService {
    private UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public void remove(User user) {
        repository.remove(user);
    }

    @Override
    public User getById(Long id) {
        return repository.getById(id);
    }

    @Override
    public User getByEmail(String email) {
        return repository.getByEmail(email);
    }

    @Override
    public Set<User> getAll() {
        return repository.getAll();
    }
}

package com.epam.cinema.repository.impl;

import com.epam.cinema.model.User;
import com.epam.cinema.repository.UserRepository;

import javax.annotation.Resource;
import java.util.Set;

public class UserRepositoryImpl implements UserRepository {

    @Resource
    private Set<User> registeredUsers;

    public Set<User> getRegisteredUsers() {
        return registeredUsers;
    }

    public void setRegisteredUsers(Set<User> registeredUsers) {
        this.registeredUsers = registeredUsers;
    }

    @Override
    public void save(User user) {
        registeredUsers.add(user);
    }

    @Override
    public void remove(User user) {
        registeredUsers.remove(user);
    }

    @Override
    public User getById(Integer id) {
        return registeredUsers.stream().filter(user -> user.getId().equals(id)).findFirst().get();
    }

    @Override
    public User getByEmail(String email) {
        return registeredUsers.stream().filter(user -> user.getEmail().equals(email)).findFirst().get();
    }

    @Override
    public Set<User> getAll() {
        return registeredUsers;
    }
}

package com.epam.cinema.repository.impl;

import com.epam.cinema.model.User;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;


public class UserRepositoryImplTest {
    
    UserRepositoryImpl userRepository = new UserRepositoryImpl();
    
    @Test
    public void save() throws Exception {
        userRepository.setRegisteredUsers(new HashSet<>());
        
        userRepository.save(new User());

        Set<User> actualUsers = userRepository.getRegisteredUsers();

        assertEquals(1, actualUsers.size());
    }

    @Test
    public void remove() throws Exception {
        User petya = new User("Petya", "Petya@email.ru", 1, LocalDate.now());

        userRepository.setRegisteredUsers(prepareUsers());

        userRepository.remove(petya);

        Set<User> actualUsers = userRepository.getRegisteredUsers();

        assertEquals(2, actualUsers.size());
    }



    @Test
    public void getById() throws Exception {
        User expectedPetya = new User("Petya", "Petya@email.ru", 1, LocalDate.now());
        userRepository.setRegisteredUsers(prepareUsers());

        User actualUser = userRepository.getById(1);

        assertEquals(expectedPetya, actualUser);
    }

    @Test
    public void getByEmail() throws Exception {
        User expectedPetya = new User("Petya", "Petya@email.ru", 1, LocalDate.now());
        userRepository.setRegisteredUsers(prepareUsers());

        User actualUser = userRepository.getById(1);

        assertEquals(expectedPetya, actualUser);
    }

    @Test
    public void getAll() throws Exception {
        userRepository.setRegisteredUsers(prepareUsers());

        Set<User> actualUsers = userRepository.getAll();

        assertEquals(3, actualUsers.size());
    }

    private Set<User> prepareUsers() {
        Set<User> users = new HashSet<>();

        User petya = new User("Petya", "Petya@email.ru", 1, LocalDate.now());
        User zhora = new User("Zhora", "Zhora@email.ru", 2, LocalDate.now());
        User innokentiy = new User("Innokentiy", "Innokentiy@email.ru", 3, LocalDate.now());

        users.add(petya);
        users.add(zhora);
        users.add(innokentiy);

        return users;
    }
}
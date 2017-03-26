package com.epam.cinema.service.impl;

import com.epam.cinema.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserServiceImpl service;

    @Test
    public void save() throws Exception {
        service.save(null);

        Mockito.verify(repository).save(null);
    }

    @Test
    public void remove() throws Exception {
        service.remove(null);

        Mockito.verify(repository).remove(null);
    }

    @Test
    public void getById() throws Exception {
        service.getById(1);

        Mockito.verify(repository).getById(1);
    }

    @Test
    public void getByEmail() throws Exception {
        service.getByEmail("email");

        Mockito.verify(repository).getByEmail("email");
    }

    @Test
    public void getAll() throws Exception {
        service.getAll();

        Mockito.verify(repository).getAll();
    }

}
package com.epam.cinema.service.impl;

import com.epam.cinema.repository.EventRepository;
import com.epam.cinema.service.EventService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class EventServiceImplTest {

    @Mock
    private EventRepository repository;

    @InjectMocks
    private EventServiceImpl service;

    @Test
    public void save() throws Exception {
        service.save(null);

        Mockito.verify(repository).save(null);
        Mockito.verifyNoMoreInteractions(repository);
    }

    @Test
    public void remove() throws Exception {
        service.remove(null);

        Mockito.verify(repository).remove(null);
        Mockito.verifyNoMoreInteractions(repository);
    }

    @Test
    public void getById() throws Exception {
        service.getById(1);

        Mockito.verify(repository).getById(1);
        Mockito.verifyNoMoreInteractions(repository);
    }

    @Test
    public void getByName() throws Exception {
        service.getByName("name");

        Mockito.verify(repository).getByName("name");
        Mockito.verifyNoMoreInteractions(repository);
    }

    @Test
    public void getAll() throws Exception {
        service.getAll();

        Mockito.verify(repository).getAll();
        Mockito.verifyNoMoreInteractions(repository);
    }

}
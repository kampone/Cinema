package com.epam.cinema.service.impl;

import com.epam.cinema.repository.AuditoriumRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class AuditoriumServiceImplTest {
    @Mock
    private AuditoriumRepository auditoriumRepository;

    @InjectMocks
    private AuditoriumServiceImpl auditoriumService;
    @Test
    public void getAll() throws Exception {
        auditoriumService.getAll();

        Mockito.verify(auditoriumRepository).getAllAuditoriums();
    }

    @Test
    public void getByName() throws Exception {
        String name = "name";
        auditoriumService.getByName(name);

        verify(auditoriumRepository).findAuditoriumByName(name);
    }

}
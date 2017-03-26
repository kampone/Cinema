package com.epam.cinema.repository.impl;

import com.epam.cinema.model.Auditorium;
import com.epam.cinema.service.BookingService;
import com.epam.cinema.service.impl.BookingServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class BookingRepositoryImplTest {
    private BookingRepositoryImpl bookingRepository = new BookingRepositoryImpl();
    @Test
    public void getAll() throws Exception {
        List<Auditorium> expectedAuditoriums = Arrays.asList(
                new Auditorium("auditorium1", Collections.emptyList()),
                new Auditorium("auditorium2", Collections.emptyList()),
                new Auditorium("auditorium3", Collections.emptyList())
                );
        bookingRepository.setAuditoriums(expectedAuditoriums);

        List<Auditorium> actualAuditoriums = bookingRepository.getAll();

        assertEquals(expectedAuditoriums, actualAuditoriums);
    }

}
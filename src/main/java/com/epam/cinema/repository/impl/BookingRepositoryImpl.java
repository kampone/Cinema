package com.epam.cinema.repository.impl;

import com.epam.cinema.model.Auditorium;
import com.epam.cinema.repository.BookingRepository;

import java.util.List;

public class BookingRepositoryImpl implements BookingRepository {
    private List<Auditorium> auditoriums;

    public List<Auditorium> getAuditoriums() {
        return auditoriums;
    }

    public void setAuditoriums(List<Auditorium> auditoriums) {
        this.auditoriums = auditoriums;
    }

    @Override
    public List<Auditorium> getAll() {
        return getAuditoriums();
    }
}

package com.epam.cinema.service.impl;

import com.epam.cinema.model.Auditorium;
import com.epam.cinema.repository.AuditoriumRepository;
import com.epam.cinema.repository.SeatRepository;
import com.epam.cinema.service.AuditoriumService;

import java.util.List;

public class AuditoriumServiceImpl implements AuditoriumService {

    private AuditoriumRepository auditoriumRepository;

    public void setAuditoriumRepository(AuditoriumRepository auditoriumRepository) {
        this.auditoriumRepository = auditoriumRepository;
    }

    @Override
    public List<Auditorium> getAll() {
        return auditoriumRepository.getAll();
    }

    @Override
    public Auditorium getByName(String name) {
        return auditoriumRepository.findByName(name);
    }
}

package com.epam.cinema.service.impl;

import com.epam.cinema.model.Auditorium;
import com.epam.cinema.service.AuditoriumService;

import java.util.List;

public class AuditoriumServiceImpl implements AuditoriumService {

    private List<Auditorium> auditoriums;

    public List<Auditorium> getAuditoriums() {
        return auditoriums;
    }

    public void setAuditoriums(List<Auditorium> auditoriums) {
        this.auditoriums = auditoriums;
    }

    @Override
    public List<Auditorium> getAll() {
        return auditoriums;
    }

    @Override
    public Auditorium getByName(String name) {
        return auditoriums.stream().filter(auditorium -> auditorium.getName().equals(name)).findFirst().get();
    }
}

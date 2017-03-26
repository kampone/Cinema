package com.epam.cinema.model;

import java.time.LocalDateTime;

public class Ticket {
    private Integer id;
    private Event event;
    private LocalDateTime dateTime;
    private Seat seat;
    private User user;
    private boolean isBooked;

    public Ticket() {
    }

    public Ticket(Integer id, Event event, LocalDateTime dateTime, Seat seat, User user, boolean isBooked) {
        this.id = id;
        this.event = event;
        this.dateTime = dateTime;
        this.seat = seat;
        this.user = user;
        this.isBooked = isBooked;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
}

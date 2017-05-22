package com.epam.cinema.model;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "TICKETS")
@Access(AccessType.FIELD)
@SequenceGenerator(name = "ticket_sequence", initialValue = 100, allocationSize = 100)
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_sequence")
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
    @Column(name = "datetime")
    private LocalDateTime dateTime;
    @OneToOne
    private Seat seat;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "booked")
    private boolean isBooked;

    public Ticket() {
    }

    public Ticket(Long id, Event event, LocalDateTime dateTime, Seat seat, User user, boolean isBooked) {
        this.id = id;
        this.event = event;
        this.dateTime = dateTime;
        this.seat = seat;
        this.user = user;
        this.isBooked = isBooked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (isBooked != ticket.isBooked) return false;
        if (id != null ? !id.equals(ticket.id) : ticket.id != null) return false;
        if (event != null ? !event.equals(ticket.event) : ticket.event != null) return false;
        if (dateTime != null ? !dateTime.equals(ticket.dateTime) : ticket.dateTime != null) return false;
        if (seat != null ? !seat.equals(ticket.seat) : ticket.seat != null) return false;
        return user != null ? user.equals(ticket.user) : ticket.user == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (event != null ? event.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        result = 31 * result + (seat != null ? seat.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (isBooked ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", event=" + event +
                ", dateTime=" + dateTime +
                ", seat=" + seat +
                ", isBooked=" + isBooked +
                '}'+ System.lineSeparator();
    }
}

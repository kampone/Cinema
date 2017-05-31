package com.epam.cinema.model;


import javax.persistence.*;
@Entity
@Table(name = "USER_TICKET")
@Access(AccessType.FIELD)
public class UserTicket {
    @Column(name = "user_id")
    private Long userId;
    @Id
    @Column(name = "ticket_id")
    private Long ticketId;

    public UserTicket() {
    }

    public UserTicket(Long userId, Long ticketId) {
        this.userId = userId;
        this.ticketId = ticketId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserTicket that = (UserTicket) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        return ticketId != null ? ticketId.equals(that.ticketId) : that.ticketId == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (ticketId != null ? ticketId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserTicket{" +
                "userId=" + userId +
                ", ticketId=" + ticketId +
                '}';
    }
}

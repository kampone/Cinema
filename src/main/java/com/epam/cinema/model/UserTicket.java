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
}

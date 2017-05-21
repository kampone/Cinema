package com.epam.cinema.model;


import javax.persistence.*;
@Entity
@Table(name = "USER_TICKET")
@Access(AccessType.FIELD)
public class UserTickets {
    @Column(name = "user_id")
    private Long userId;
    @Id
    @Column(name = "ticket_id")
    private Long ticketId;

}

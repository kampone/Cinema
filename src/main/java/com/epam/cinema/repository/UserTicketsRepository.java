package com.epam.cinema.repository;


import java.util.List;

public interface UserTicketsRepository {
    List<Long> getUserTicketsIds();
    void addUserTicket(Long userId, Long ticketId);
}

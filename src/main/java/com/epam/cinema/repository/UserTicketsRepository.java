package com.epam.cinema.repository;


import java.util.List;

public interface UserTicketsRepository {
    List<Long> getUserTicketsIds(Long userId);

    void addUserTicket(Long userId, Long ticketId);
}

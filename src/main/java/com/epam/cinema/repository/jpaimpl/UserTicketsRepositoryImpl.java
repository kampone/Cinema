package com.epam.cinema.repository.jpaimpl;

import com.epam.cinema.model.UserTicket;
import com.epam.cinema.repository.UserTicketsRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
@Profile("jpa")
public class UserTicketsRepositoryImpl implements UserTicketsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Long> getUserTicketsIds(Long userId) {
        return entityManager.createQuery("select ut from UserTicker ut where ut.userId = :userId", UserTicket.class)
                .setParameter("userId", userId)
                .getResultList().stream().map(UserTicket::getTicketId).collect(Collectors.toList());
    }

    @Override
    public void addUserTicket(Long userId, Long ticketId) {
        entityManager.persist(new UserTicket(userId, ticketId));
    }
}

package com.epam.cinema.repository.jpaimpl;

import com.epam.cinema.model.Ticket;
import com.epam.cinema.model.User;
import com.epam.cinema.repository.TicketRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
@Profile("jpa")
public class TicketRepositoryImpl implements TicketRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Ticket> getAllTickets() {
        return  entityManager.createQuery("select t from Ticket t", Ticket.class).getResultList();
    }

    @Override
    public List<Ticket> getTicketsForUser(Long userId) {
        return entityManager.createQuery("select t from Ticket t join t.user u where u.id = :id", Ticket.class).setParameter("id", userId).getResultList();
    }

    @Override
    public void bookTicketForUser(Ticket ticket, Long userId) {

        User user = entityManager.find(User.class, userId);
        ticket.setUser(user);
        ticket.setBooked(true);
        user.getTickets().add(ticket);
    }

    @Override
    public void saveTicket(Ticket ticket) {
        entityManager.persist(ticket);
    }

    @Override
    public void unbookTicketForUser(Ticket ticket, Long userId) {
        User user = entityManager.find(User.class, userId);
        user.getTickets().remove(ticket);
        Ticket ticket1 = entityManager.find(Ticket.class, ticket.getId());
        ticket1.setUser(null);
        ticket1.setBooked(false);
    }

    @Override
    public void buyTicket(Long ticketId) {
        entityManager.find(Ticket.class, ticketId).setUser(null);
    }
}

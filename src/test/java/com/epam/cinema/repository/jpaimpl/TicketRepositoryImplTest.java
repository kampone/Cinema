package com.epam.cinema.repository.jpaimpl;

import com.epam.cinema.model.Ticket;
import com.epam.cinema.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class TicketRepositoryImplTest {
    @Mock
    private EntityManager entityManager;

    @InjectMocks
    private TicketRepositoryImpl ticketRepository;

    @Test
    public void getAllTickets() throws Exception {
        TypedQuery query = mock(TypedQuery.class);

        when(entityManager.createQuery(anyString(), anyObject())).thenReturn(query);

        ticketRepository.getAllTickets();

        verify(entityManager).createQuery(anyString(), anyObject());
        verify(query).getResultList();
    }

    @Test
    public void getTicketsForUser() throws Exception {
        Long id = 1L;
        TypedQuery query = mock(TypedQuery.class);

        when(entityManager.createQuery(anyString(), anyObject())).thenReturn(query);
        when(query.setParameter("id", id)).thenReturn(query);

        ticketRepository.getTicketsForUser(id);

        verify(entityManager).createQuery(anyString(), anyObject());
        verify(query).setParameter("id", id);
        verify(query).getResultList();

    }

    @Test
    public void bookTicketForUser() throws Exception {
        User user = new User();
        user.setTickets(new ArrayList<>());
        Ticket ticket = new Ticket();
        Long id = 1L;

        when(entityManager.find(User.class, id)).thenReturn(user);

        ticketRepository.bookTicketForUser(ticket, id);

        verify(entityManager).find(User.class, id);
        assertTrue(user.getTickets().contains(ticket));
        assertTrue(ticket.isBooked());
        assertEquals(ticket.getUser(), user);
    }

    @Test
    public void saveTicket() throws Exception {
        Ticket ticket = new Ticket();

        ticketRepository.saveTicket(ticket);

        verify(entityManager).persist(ticket);
    }

    @Test
    public void unbookTicketForUser() throws Exception {
        Long userId = 1L;
        Long ticketId = 2L;
        Ticket ticket = new Ticket();
        User user = new User();
        ArrayList<Ticket> tickets = new ArrayList<>();
        tickets.add(ticket);
        user.setTickets(tickets);
        ticket.setId(ticketId);
        ticket.setUser(user);
        ticket.setBooked(true);

        when(entityManager.find(User.class, userId)).thenReturn(user);
        when(entityManager.find(Ticket.class, ticketId)).thenReturn(ticket);

        ticketRepository.unbookTicketForUser(ticket, userId);

        verify(entityManager).find(User.class, userId);
        verify(entityManager).find(Ticket.class, ticketId);
        assertNull(ticket.getUser());
        assertFalse(ticket.isBooked());
    }

    @Test
    public void buyTicket() throws Exception {
        Long id = 1L;
        Ticket ticket = new Ticket();
        ticket.setUser(new User());

        when(entityManager.find(Ticket.class, id)).thenReturn(ticket);

        ticketRepository.buyTicket(id);

        verify(entityManager).find(Ticket.class, id);
        assertNull(ticket.getUser());
    }

}
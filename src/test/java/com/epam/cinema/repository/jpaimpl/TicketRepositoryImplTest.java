package com.epam.cinema.repository.jpaimpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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

    }

    @Test
    public void bookTicketForUser() throws Exception {
    }

    @Test
    public void saveTicket() throws Exception {
    }

    @Test
    public void unbookTicketForUser() throws Exception {
    }

    @Test
    public void buyTicket() throws Exception {
    }

}
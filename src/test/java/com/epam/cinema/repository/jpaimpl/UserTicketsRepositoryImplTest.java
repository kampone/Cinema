package com.epam.cinema.repository.jpaimpl;

import com.epam.cinema.model.UserTicket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class UserTicketsRepositoryImplTest {
    @Mock
    private EntityManager entityManager;

    @InjectMocks
    private UserTicketsRepositoryImpl userTicketsRepository;
    @Test
    public void getUserTicketsIds() throws Exception {
        List<UserTicket> expectedUserTickets = asList(
                new UserTicket(1L, 2L),
                new UserTicket(3L, 4L),
                new UserTicket(5L, 6L),
                new UserTicket(7L, 8L)
        );

        List<Long> expectedIds = asList(2L, 4L, 6L, 8L);

        Long id = 1L;
        TypedQuery query = mock(TypedQuery.class);

        when(entityManager.createQuery(anyString(), anyObject())).thenReturn(query);
        when(query.setParameter("userId", id)).thenReturn(query);
        when(query.getResultList()).thenReturn(expectedUserTickets);

        List<Long> actualIds = userTicketsRepository.getUserTicketsIds(id);

        verify(entityManager).createQuery(anyString(), anyObject());
        verify(query).setParameter("userId", id);
        verify(query).getResultList();

        assertEquals(expectedIds, actualIds);
    }

    @Test
    public void addUserTicket() throws Exception {
        Long userId = 1L;
        Long ticketId = 2L;

        userTicketsRepository.addUserTicket(userId, ticketId);

        verify(entityManager).persist(new UserTicket(userId, ticketId));
    }

}
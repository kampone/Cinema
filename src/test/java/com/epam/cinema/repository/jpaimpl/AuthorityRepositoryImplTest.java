package com.epam.cinema.repository.jpaimpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class AuthorityRepositoryImplTest {
    @Mock
    private EntityManager entityManager;

    @InjectMocks
    private AuthorityRepositoryImpl authorityRepository;

    @Test
    public void assignUser() throws Exception {
        String username = "username";
        Query query = mock(Query.class);

        when(entityManager.createNativeQuery(anyString())).thenReturn(query);
        when(query.setParameter(1, username)).thenReturn(query);

        authorityRepository.assignUser(username);

        verify(entityManager).createNativeQuery(anyString());
        verify(query).setParameter(1, username);
        verify(query).executeUpdate();
    }

    @Test
    public void getAuthority() throws Exception {
        String username = "username";
        Query query = mock(Query.class);

        when(entityManager.createNativeQuery(anyString())).thenReturn(query);
        when(query.getSingleResult()).thenReturn(new Object());

        authorityRepository.getAuthority(username);

        verify(entityManager).createNativeQuery(anyString());
        verify(query).getSingleResult();
    }
}
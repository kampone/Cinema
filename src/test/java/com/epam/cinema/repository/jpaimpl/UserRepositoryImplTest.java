package com.epam.cinema.repository.jpaimpl;

import com.epam.cinema.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class UserRepositoryImplTest {
    @Mock
    private EntityManager entityManager;

    @InjectMocks
    private UserRepositoryImpl userRepository;

    @Test
    public void saveUser() throws Exception {
        User user = new User();

        userRepository.saveUser(user);

        verify(entityManager).persist(user);
    }

    @Test
    public void removeUser() throws Exception {
        User user = new User();

        userRepository.removeUser(user);

        verify(entityManager).remove(user);
    }

    @Test
    public void getUserById() throws Exception {
        CriteriaBuilder criteriaBuilder = mock(CriteriaBuilder.class);
        CriteriaQuery criteriaQuery = mock(CriteriaQuery.class);
        TypedQuery query = mock(TypedQuery.class);
        Root root = mock(Root.class);

        when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        when(criteriaBuilder.createQuery(User.class)).thenReturn(criteriaQuery);
        when(criteriaQuery.from(User.class)).thenReturn(root);
        when(criteriaQuery.select(root)).thenReturn(criteriaQuery);
        when(entityManager.createQuery(criteriaQuery)).thenReturn(query);


        userRepository.getUserById(1L);

        verify(entityManager).getCriteriaBuilder();
        verify(criteriaBuilder).createQuery(User.class);
        verify(criteriaQuery).from(User.class);
        verify(criteriaQuery).select(root);
        verify(entityManager).createQuery(criteriaQuery);
        verify(query).getSingleResult();
    }

    @Test
    public void getUserByEmail() throws Exception {
        CriteriaBuilder criteriaBuilder = mock(CriteriaBuilder.class);
        CriteriaQuery criteriaQuery = mock(CriteriaQuery.class);
        TypedQuery query = mock(TypedQuery.class);
        Root root = mock(Root.class);

        when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        when(criteriaBuilder.createQuery(User.class)).thenReturn(criteriaQuery);
        when(criteriaQuery.from(User.class)).thenReturn(root);
        when(criteriaQuery.select(root)).thenReturn(criteriaQuery);
        when(entityManager.createQuery(criteriaQuery)).thenReturn(query);


        userRepository.getUserByEmail("email");

        verify(entityManager).getCriteriaBuilder();
        verify(criteriaBuilder).createQuery(User.class);
        verify(criteriaQuery).from(User.class);
        verify(criteriaQuery).select(root);
        verify(entityManager).createQuery(criteriaQuery);
        verify(query).getSingleResult();
    }

    @Test
    public void getAllUser() throws Exception {
        Long id = 1L;
        TypedQuery query = mock(TypedQuery.class);

        when(entityManager.createNamedQuery("findAllUsers")).thenReturn(query);

        userRepository.getAllUser();

        verify(entityManager).createNamedQuery("findAllUsers");
        verify(query).getResultList();
    }

}
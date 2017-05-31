package com.epam.cinema.repository.jpaimpl;

import com.epam.cinema.model.Auditorium;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class AuditoriumRepositoryImplTest {

    @Mock
    private EntityManager entityManager;

    @InjectMocks
    private AuditoriumRepositoryImpl auditoriumRepository;

    @Test
    public void getAllAuditoriums() throws Exception {
        Query query = mock(Query.class);
        when(entityManager.createNamedQuery(anyString())).thenReturn(query);
        auditoriumRepository.getAllAuditoriums();

        verify(entityManager).createNamedQuery(anyString());
    }

    @Test
    public void findAuditoriumByName() throws Exception {
        CriteriaBuilder criteriaBuilder = mock(CriteriaBuilder.class);
        CriteriaQuery criteriaQuery = mock(CriteriaQuery.class);
        TypedQuery query = mock(TypedQuery.class);
        Root root = mock(Root.class);

        when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        when(criteriaBuilder.createQuery(Auditorium.class)).thenReturn(criteriaQuery);
        when(criteriaQuery.from(Auditorium.class)).thenReturn(root);
        when(criteriaQuery.select(root)).thenReturn(criteriaQuery);
        when(entityManager.createQuery(criteriaQuery)).thenReturn(query);


        auditoriumRepository.findAuditoriumByName("name");

        verify(entityManager).getCriteriaBuilder();
        verify(criteriaBuilder).createQuery(Auditorium.class);
        verify(criteriaQuery).from(Auditorium.class);
        verify(criteriaQuery).select(root);
        verify(entityManager).createQuery(criteriaQuery);
        verify(query).getSingleResult();
    }

    @Test
    public void saveAuditorium() throws Exception {
        Auditorium auditorium = new Auditorium();

        auditoriumRepository.saveAuditorium(auditorium);

        verify(entityManager).persist(auditorium);
    }

}
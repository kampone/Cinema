package com.epam.cinema.repository.jpaimpl;

import com.epam.cinema.model.Auditorium;
import com.epam.cinema.repository.AuditoriumRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@Profile("jpa")
public class AuditoriumRepositoryImpl implements AuditoriumRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Auditorium> getAllAuditoriums() {
        return entityManager.createNamedQuery("findAllAuditoriums").getResultList();
    }

    @Override
    public Auditorium findAuditoriumByName(String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Auditorium> criteriaQuery = criteriaBuilder.createQuery(Auditorium.class);
        Root<Auditorium> auditorium = criteriaQuery.from(Auditorium.class);
        criteriaQuery.select(auditorium).where(criteriaBuilder.equal(auditorium.get("name"), name));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public void saveAuditorium(Auditorium auditorium) {
        entityManager.persist(auditorium);
    }
}

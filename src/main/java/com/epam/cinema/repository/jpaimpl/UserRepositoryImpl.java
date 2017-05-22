package com.epam.cinema.repository.jpaimpl;

import com.epam.cinema.model.User;
import com.epam.cinema.repository.UserRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashSet;
import java.util.Set;

@Repository
@Transactional
@Profile("jpa")
public class UserRepositoryImpl implements UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeUser(User user) {
        entityManager.remove(user);
    }

    @Override
    public User getUserById(Long id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> user = criteriaQuery.from(User.class);
        criteriaQuery.select(user).where(criteriaBuilder.equal(user.get("id"), id));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public User getUserByEmail(String email) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> user = criteriaQuery.from(User.class);
        criteriaQuery.select(user).where(criteriaBuilder.equal(user.get("email"), email));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public Set<User> getAllUser() {
        return new HashSet<User>(entityManager.createNamedQuery("findAllUsers").getResultList());
    }
}

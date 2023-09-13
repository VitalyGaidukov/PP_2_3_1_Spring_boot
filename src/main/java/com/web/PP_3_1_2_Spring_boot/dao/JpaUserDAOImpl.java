package com.web.PP_3_1_2_Spring_boot.dao;

import com.web.PP_3_1_2_Spring_boot.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
public class JpaUserDAOImpl implements JpaUserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        Query queue = entityManager.createQuery("delete from User u where u.id =:id");
        queue.setParameter("id", id);
        queue.executeUpdate();
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }
}
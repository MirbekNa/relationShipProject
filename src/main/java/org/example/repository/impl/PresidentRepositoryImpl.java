package org.example.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.entity.Country;
import org.example.entity.President;
import org.example.hibernateCon.HiberCon;
import org.example.repository.PresidentRepository;
import org.hibernate.SessionFactory;

import java.util.List;

public class PresidentRepositoryImpl implements PresidentRepository {
    public final EntityManagerFactory entityManagerFactory = HiberCon.getSessionFactory();
    private SessionFactory sessionFactory = HiberCon.getSessionFactory();

    @Override
    public String save(President president) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(president);
        entityManager.getTransaction().commit();
        entityManager.close();
        return president.getFirstName() + "saved";
    }


    @Override
    public String delete(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        President president = entityManager.find(President.class, id);
        if (president != null) {
            entityManager.remove(president);
            entityManager.getTransaction().commit();
            entityManager.close();
            return president.getFirstName() + "Страна успешно удалена.";
        }
        return null;
    }

    @Override
    public void getPresidents(List<President> presidents) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<President> presidentList = entityManager.createQuery("SELECT p FROM President p ", President.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println(presidentList + " Geted");
    }

}

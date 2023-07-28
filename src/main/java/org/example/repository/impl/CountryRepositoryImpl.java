package org.example.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.entity.Country;
import org.example.hibernateCon.HiberCon;
import org.example.repository.CountryRepository;
import org.hibernate.SessionFactory;

import java.util.List;

public class CountryRepositoryImpl implements CountryRepository {
    public final EntityManagerFactory entityManagerFactory = HiberCon.getSessionFactory();
    private SessionFactory sessionFactory = HiberCon.getSessionFactory();

    @Override
    public String save(Country country) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(country);
        entityManager.getTransaction().commit();
        entityManager.close();
        return country.getName() + "saved";
    }

    @Override
    public String delete(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Country country = entityManager.find(Country.class, id);
        if (country != null) {
            entityManager.remove(country);
            entityManager.getTransaction().commit();
            entityManager.close();
            return country.getName()+"Страна успешно удалена.";
        }
    return null;}

    @Override
    public void getCountries(List<Country> countries) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Country> countryList = entityManager.createQuery("SELECT c FROM Country c", Country.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println(countryList + " Geted");
    }

}

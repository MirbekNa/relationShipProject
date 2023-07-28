package org.example.hibernateCon;

import jakarta.persistence.EntityManager;
import org.example.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HiberCon {
    public static SessionFactory getSessionFactory() {
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
        properties.put(Environment.USER, "postgres");
        properties.put(Environment.PASS, "postgres");
        properties.put(Environment.HBM2DDL_AUTO, "update");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.SHOW_SQL, "true");
        Configuration configuration = new Configuration();
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(President.class);
        configuration.addAnnotatedClass(Country.class);
        return configuration.buildSessionFactory();
    }
    public static EntityManager createEntityManager() {
        return getSessionFactory().createEntityManager();
    }
}

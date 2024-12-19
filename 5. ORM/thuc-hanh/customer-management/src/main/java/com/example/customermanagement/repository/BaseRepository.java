package com.example.customermanagement.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;

public class BaseRepository {
    public static SessionFactory sessionFactory;
    public static EntityManager entityManager;
    static {
        sessionFactory = new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
        entityManager = sessionFactory.createEntityManager();
    }
    // Phương thức mở session và transaction
    public static Session openSession() {
        return sessionFactory.openSession();
    }

    // Phương thức mở transaction
    public static Transaction beginTransaction(Session session) {
        return session.beginTransaction();
    }
}

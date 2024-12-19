package com.example.customermanagement.repository;

import com.example.customermanagement.model.Customer;

import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    public List<Customer> findAll() {
        return BaseRepository.entityManager.createQuery("from Customer", Customer.class).getResultList();
    }

    public void save(Customer customer) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        try {
            transaction.begin();
            if (customer.getId() == 0) {
                BaseRepository.entityManager.persist(customer); // Thêm khách hàng mới
            } else {
                BaseRepository.entityManager.merge(customer); // Cập nhật khách hàng hiện có
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public void remove(int id) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        try {
            transaction.begin();
            Customer customer = BaseRepository.entityManager.find(Customer.class, id);
            if (customer != null) {
                BaseRepository.entityManager.remove(customer);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }
}

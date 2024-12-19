package com.example.customermanagement.service;

import com.example.customermanagement.model.Customer;

import java.util.List;

public interface IService<Customer> {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void remove(int id);
}

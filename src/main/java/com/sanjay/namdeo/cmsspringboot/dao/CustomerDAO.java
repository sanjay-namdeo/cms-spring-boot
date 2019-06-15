package com.sanjay.namdeo.cmsspringboot.dao;

import com.sanjay.namdeo.cmsspringboot.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerDAO extends CrudRepository<Customer, Integer> {

    @Override
    List<Customer> findAll();
}

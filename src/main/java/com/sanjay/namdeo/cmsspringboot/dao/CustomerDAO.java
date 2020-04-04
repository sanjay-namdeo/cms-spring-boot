package com.sanjay.namdeo.cmsspringboot.dao;

import com.sanjay.namdeo.cmsspringboot.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDAO extends CrudRepository<Customer, Integer> {
}

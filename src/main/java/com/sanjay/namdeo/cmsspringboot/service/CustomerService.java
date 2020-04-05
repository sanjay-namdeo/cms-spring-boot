package com.sanjay.namdeo.cmsspringboot.service;

import com.sanjay.namdeo.cmsspringboot.dao.CustomerDAO;
import com.sanjay.namdeo.cmsspringboot.exception.CustomerNotFoundException;
import com.sanjay.namdeo.cmsspringboot.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    // Get all customers
    public List<Customer> getAllCustomers() {
        List<Customer> customerList = new ArrayList<>();
        customerDAO.findAll().forEach(customerList::add);
        return customerList;
    }

    // Add a new customer
    public Customer addCustomer(Customer customer) {
        return customerDAO.save(customer);
    }

    // Add a new customer
    public List<Customer> addAll(List<Customer> customers) {
        Iterable<Customer> customerIterator = customerDAO.saveAll(customers);
        List<Customer> customerList = new ArrayList<>();
        customerIterator.forEach(customer -> {
            customerList.add(customer);
        });
        return customerList;
    }

    // Get customer by Id
    public Customer getCustomer(int customerId) {
        Optional<Customer> optionalCustomer = customerDAO.findById(customerId);
        if (!optionalCustomer.isPresent())
            throw new CustomerNotFoundException("Customer not found.");
        return optionalCustomer.get();
    }

    // Delete customer
    public void deleteCustomer(int customerId) {
        customerDAO.deleteById(customerId);
    }

    public void deleteAll() {
        customerDAO.deleteAll();
    }

    // Update customer
    public Customer updateCustomer(int customerId, Customer customer) {
        customer.setId(customerId);
        return customerDAO.save(customer);
    }
}

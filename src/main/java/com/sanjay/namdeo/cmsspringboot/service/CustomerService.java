package com.sanjay.namdeo.cmsspringboot.service;

import com.sanjay.namdeo.cmsspringboot.dao.CustomerDAO;
import com.sanjay.namdeo.cmsspringboot.exception.CustomerNotFoundException;
import com.sanjay.namdeo.cmsspringboot.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    // Get all customers
    public List<Customer> getAllCustomers() {
        return customerDAO.findAll();
    }

    // Add a new customer
    public Customer addCustomer(Customer customer) {
        return customerDAO.save(customer);
    }

    // Get customer by Id
    public Customer getCustomer(int customerId) {
        Optional<Customer> optionalCustomer = customerDAO.findById(customerId);
        if(!optionalCustomer.isPresent())
            throw new CustomerNotFoundException("Customer not found.");
        return optionalCustomer.get();
    }

    // Delete customer
    public void deleteCustomer(int customerId) {
        customerDAO.deleteById(customerId);
    }

    // Update customer
    public Customer updateCustomer(int customerId, Customer customer) {
        customer.setId(customerId);
        return customerDAO.save(customer);
    }
}

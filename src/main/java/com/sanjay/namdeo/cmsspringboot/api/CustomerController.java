package com.sanjay.namdeo.cmsspringboot.api;

import com.sanjay.namdeo.cmsspringboot.model.Customer;
import com.sanjay.namdeo.cmsspringboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v2")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    public List<Customer> addAllCustomers(@RequestBody List<Customer> customers) {
        return customerService.addAll(customers);
    }

    @GetMapping(value = "/customers")
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping(value = "/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {
        return customerService.getCustomer(customerId);
    }

    @DeleteMapping(value = "customers/{customerId}")
    public void deleteCustomer(@PathVariable int customerId) {
        customerService.deleteCustomer(customerId);
    }

    @DeleteMapping(value = "/customers")
    public void deleteAll() {
        customerService.deleteAll();
    }

    @PutMapping(value = "customers/{customerId}")
    public Customer updateCustomer(@PathVariable int customerId, @RequestBody Customer customer) {
        return customerService.updateCustomer(customerId, customer);
    }
}

package com.sanjay.namdeo.cmsspringboot.api;

import com.sanjay.namdeo.cmsspringboot.model.Customer;
import com.sanjay.namdeo.cmsspringboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @PostMapping(value = "addAll")
    public List<Customer> addAllCustomers(@RequestBody List<Customer> customers) {
        return customerService.addAll(customers);
    }

    @GetMapping(value = "/getAll")
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping(value = "/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {
        return customerService.getCustomer(customerId);
    }

    @DeleteMapping(value = "/{customerId}")
    public void deleteCustomer(@PathVariable int customerId) {
        customerService.deleteCustomer(customerId);
    }

    @DeleteMapping(value = "deleteAll")
    public void deleteAll() {
        customerService.deleteAll();
    }

    @PutMapping(value = "/{customerId}")
    public Customer updateCustomer(@PathVariable int customerId, @RequestBody Customer customer) {
        return customerService.updateCustomer(customerId, customer);
    }
}

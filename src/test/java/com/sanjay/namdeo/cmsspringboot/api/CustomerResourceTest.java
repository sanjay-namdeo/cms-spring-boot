package com.sanjay.namdeo.cmsspringboot.api;

import com.sanjay.namdeo.cmsspringboot.model.Customer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerResourceTest {
    @Autowired
    private CustomerResource customerResource;

    @Before
    public void beforeTest() {
        Customer[] customers = {new Customer("Vaibhav", "vaibah@amil.com"), new Customer("Anshul", "ansul.com"),
                new Customer("Saurabh", "sauravh.com"), new Customer("Surendra", "suredra.com")};
        customerResource.addAllCustomers(Arrays.asList(customers));
    }

    @After
    public void afterTest() {
        customerResource.deleteAll();
    }

    @Test
    public void addCustomer() {
        Customer newCustomer = new Customer("Sanjay Namdeo", "sanjay.namdeo@live.com");
        Customer savedCustomer = customerResource.addCustomer(newCustomer);
        assert newCustomer.equals(savedCustomer);
    }

    @Test
    public void getCustomers() {
        assert customerResource.getCustomers().size() == 5;
    }

    @Test
    public void getCustomer() {
        assert customerResource.getCustomer(1).equals(new Customer("Vaibhav", "vaibah@amil.com"));
    }

    @Test
    public void deleteCustomer() {
        customerResource.deleteCustomer(1);
        assert customerResource.getCustomer(1) == null;
    }

    @Test
    public void updateCustomer() {
        customerResource.updateCustomer(1, new Customer("Sanjay", "sanjay@email.com"));
        assert customerResource.getCustomer(1).equals(new Customer("Sanjay", "sanjay@email.com"));
    }


    @Test
    public void testGetCustomer() {
    }

    @Test
    public void testDeleteCustomer() {
    }

    @Test
    public void testUpdateCustomer() {
    }
}
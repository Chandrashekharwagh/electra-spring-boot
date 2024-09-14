package com.electra.controller;

import com.electra.domain.Customer;
import com.electra.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    //@RequestMapping(path = "/customer", method = RequestMethod.GET)
    @GetMapping("/customer")
    public List<Customer> retrieveCustomers() {
        return customerService.retrieveCustomers();
    }

    @GetMapping("/customer/{customerId}")
    public String retrieveCustomerForCustomerId(@PathVariable int customerId) {
        return customerService.search(customerId);
    }

    @DeleteMapping("/customer/{customerId}")
    public String deleteCustomerForCustomerId(@PathVariable int customerId) {
        return customerService.deleteCustomer(customerId);
    }

    @PostMapping("/customer")
    public String addCustomer(@RequestBody Customer customer) {
        return customerService.storeCustomer(customer);
    }

    @PutMapping("/customer/{customerId}")
    public String updateCustomerForCustomerId(@PathVariable int customerId, @RequestBody Customer customer) {
        return customerService.updateCustomer(customerId, customer);
    }
}
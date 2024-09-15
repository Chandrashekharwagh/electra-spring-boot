package com.electra.service;

import com.electra.domain.Address;
import com.electra.domain.Customer;
import com.electra.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {
    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    private CustomerRepository customerRepo;

    public List<Customer> retrieveCustomers() {
        logger.info("Inside CustomerService.retrieveCustomers()");

        // Retrieve the list of customers from the repository
        List<Customer> customers = customerRepo.retrieve();

        // Log the number of customers retrieved
        logger.info("Number of customers retrieved: " + customers.size());

        // Return the list of customers
        return customers;
    }


    public String storeCustomer(Customer customer) {
        logger.info("/inside the CustomerService.storeCustomer");
        return customerRepo.store(customer, customer.getAddress());
    }

    public String deleteCustomer(int id) {
        logger.info("Inside CustomerService.deleteCustomer()");
        return customerRepo.delete(id);
    }


    public String search(int customerId) {
        logger.info("/inside the CustomerService.search");
        return customerRepo.search(customerId);  // Delegate to the repository method
    }


    public String updateCustomer(int id, Customer customer , Address address) {
        logger.info("/inside the CustomerService.updateCustomer()");
        customer.setId(id);
        address.setId(address.getId());
        return customerRepo.update(customer , address);
    }
}

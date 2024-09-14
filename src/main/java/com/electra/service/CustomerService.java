package com.electra.service;

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
    private CustomerRepository repo;

    public List<Customer> retrieveCustomers() {
        logger.info("/inside the CustomerService.retrieveCustomers()");
        return repo.retrieve();
    }

    public String storeCustomer(Customer customer) {
        logger.info("/inside the CustomerService.addCustomer()");;
        return repo.store(customer);
    }

    public String deleteCustomer(int id) {
        logger.info("/inside the CustomerService.removeCustomer()");
        return repo.delete(id);
    }

    public String search(int id) {
        logger.info("/inside the CustomerService.search()");
        return repo.search(id);
    }

    public String updateCustomer(int id, Customer customer) {
        logger.info("/inside the CustomerService.updateCustomer()");
        customer.setId(id);
        return repo.update(customer);
    }
}

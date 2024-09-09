package com.electra.repository;


import com.electra.domain.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository implements CustomerEntryRepository<Customer>{
    private static final Logger logger = LoggerFactory.getLogger(CustomerRepository.class);
    private List<Customer> customerList = new ArrayList<>();
    private int index = -1;

    public String store(Customer customer) {
        logger.info("/inside the CustomerRepository.store()");
        customer.setId(++index);
        customerList.add(index, customer);
        return customer.toString();
    }

    @Override
    public String delete(int id) {
        logger.info("/inside the CustomerRepository.delete()");
        customerList.remove(id);
        return "customer removed";
    }

    @Override
    public List<Customer> retrieve() {
        logger.info("/inside the CustomerRepository.retrieve()");
        return customerList;
    }

    @Override
    public String search(int index) {
        logger.info("/inside the CustomerRepository.search()");
        return this.customerList.get(index).toString();
    }

    @Override
    public String update(Customer customer) {
        logger.info("/inside the CustomerRepository.update()");
        // Checking if Name is neither null nor empty
        if (!(customer.getName().isBlank() || customer.getName().isEmpty())) {
            this.customerList.get(customer.getId()).setName(customer.getName());
        }
        return this.customerList.get(customer.getId()).toString();
    }
}

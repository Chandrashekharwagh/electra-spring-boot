package com.electra.repository;

import com.electra.domain.Address;
import com.electra.domain.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository implements CustomerEntryRepository<Customer>{
    private static final Logger logger = LoggerFactory.getLogger(CustomerRepository.class);
    private final List<Customer> customerList = new ArrayList<>();
    private final List<Address> addressList = new ArrayList<>();
    private int customerIndex = -1;

    public String store(Customer customer, Address address) {
        logger.info("Inside CustomerRepository.store()");

        // Assign the same unique ID to both customer and address
        int uniqueId = ++customerIndex;  // Increment customerIndex and use it for both

        customer.setId(uniqueId);
        address.setId(uniqueId);  // Use the same uniqueId for both customer and address

        // Add customer and address to their respective lists
        customerList.add(customer);
        addressList.add(address);

        logger.info("Customer and Address stored successfully with ID: " + uniqueId);

        // Return the customer as a string representation
        return customer.toString();
    }



    @Override
    public String delete(int id) {
        logger.info("Inside CustomerRepository.delete()");

        // Check if the customer exists
        if (id >= 0 && id < customerList.size()) {
            // Remove the customer from the customer list
            Customer removedCustomer = customerList.remove(id);

            if (removedCustomer != null) {
                logger.info("Customer with ID " + id + " and their associated addresses removed.");
                return "Customer and associated addresses removed successfully.";
            } else {
                logger.error("Failed to remove customer with ID " + id);
                return "Failed to remove customer.";
            }
        } else {
            logger.error("Customer with ID " + id + " not found.");
            return "Customer not found.";
        }
    }



    @Override
    public List<Customer> retrieve() {
        logger.info("Inside CustomerRepository.retrieve()");
        for (int i = 0; i < customerList.size(); i++) {
            Customer customer = customerList.get(i);
            logger.info("Customer: " + customer.toString());
        }
        return customerList;
    }


    @Override
    public String search(int customerId) {
        logger.info("Inside CustomerRepository.search()");

        // Find the customer by ID
        Customer customer = null;
        for (Customer c : customerList) {
            if (c.getId() == customerId) {
                customer = c;
                break;
            }
        }

        // Check if customer was found
        if (customer == null) {
            logger.error("Customer with ID " + customerId + " not found.");
            return "Customer not found";
        }

        // Log and return customer information
        logger.info("Customer found: " + customer.toString());
        return "Customer: " + customer.toString();
    }




    @Override
    public String update(Customer customer, Address address) {
        logger.info("Inside CustomerRepository.update()");

        // Check if both customer name and address fields are neither null nor empty
        if (!(customer.getName().isBlank() || customer.getName().isEmpty()) &&
                !(address.getStreet().isBlank() || address.getCity().isEmpty())) {

            // Update the customer details based on customer ID
            Customer existingCustomer = this.customerList.get(Math.toIntExact(customer.getId()));
            if (existingCustomer != null) {
                existingCustomer.setName(customer.getName());
            } else {
                logger.error("Customer with ID " + customer.getId() + " not found.");
            }
        } else {
            logger.error("Invalid customer name or address.");
        }

        // Return a meaningful string representation for both customer and address
        return customer.toString() + address.toString();
    }

}

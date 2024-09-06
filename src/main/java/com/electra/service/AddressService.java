package com.electra.service;

import com.electra.domain.Address;
import com.electra.repository.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private static final Logger logger = LoggerFactory.getLogger(AddressService.class);

    @Autowired
    private AddressRepository repo;

    public List<Address> retrieveAddresses() {
        logger.info("/inside the AddressService.retrieveAddresses()");
        return repo.retrieve();
    }

    public String storeAddress(Address address) {
        logger.info("/inside the AddressService.addAddress()");;
        return repo.store(address);
    }

    public String deleteAddress(int id) {
        logger.info("/inside the AddressService.removeAddress()");
        return repo.delete(id);
    }

    public String search(int id) {
        logger.info("/inside the AddressService.search()");
        return repo.search(id);
    }

    public String updateAddress(int id, Address address) {
        logger.info("/inside the AddressService.updateTraining()");
        address.setId(id);
        return repo.update(address);
    }
}

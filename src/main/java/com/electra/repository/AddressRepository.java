package com.electra.repository;

import com.electra.domain.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AddressRepository implements AddressEntryRepository<Address> {
    private static final Logger logger = LoggerFactory.getLogger(AddressRepository.class);
    private List<Address> addressList = new ArrayList<>();
    private int addressIndex = 0;

    public String store(Address address) {
        logger.info("/inside the AddressRepository.store()");
        int uniqueId = ++addressIndex;
        address.setId(uniqueId);
        addressList.add(address);
        logger.info("Address stored successfully with ID: " + uniqueId);
        return address.toString();
    }

    @Override
    public String delete(int id) {
        logger.info("/inside the AddressRepository.delete()");
        addressList.remove(id);
        return "address removed";
    }

    @Override
    public List<Address> retrieve() {
        logger.info("/inside the AddressRepository.retrieve()");
        return addressList;
    }

    @Override
    public String search(int index) {
        logger.info("/inside the AddressRepository.search()");
        return this.addressList.get(index).toString();
    }

    @Override
    public String update(Address address) {
        logger.info("/inside the AddressRepository.update()");

        // Checking if street is neither null nor empty
        if (!(address.getStreet().isBlank() || address.getStreet().isEmpty())) {
            this.addressList.get(Math.toIntExact(address.getId())).setStreet(address.getStreet());
        }

        // Checking if postalCode is valid (greater than 0)
        if (address.getPostalCode() > 0) {
            this.addressList.get(Math.toIntExact(address.getId())).setPostalCode(address.getPostalCode());
        }

        return this.addressList.get(Math.toIntExact(address.getId())).toString();
    }

}

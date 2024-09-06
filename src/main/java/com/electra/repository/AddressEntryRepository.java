package com.electra.repository;

import com.electra.domain.Address;

import java.util.List;

public interface AddressEntryRepository<Address> {
    public String store(Address address);

    public List<Address> retrieve();

    public String search(int id);

    public String delete(int id);

    public String update(Address address);
}

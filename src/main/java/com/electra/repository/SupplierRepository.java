package com.electra.repository;

import com.electra.domain.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SupplierRepository implements SupplierEntryRepository<Supplier>{
    private static final Logger logger = LoggerFactory.getLogger(SupplierRepository.class);
    private final List<Supplier> supplierList = new ArrayList<>();
    private int index = 0;

    public String store(Supplier supplier) {
        logger.info("/inside the SupplierRepository.store()");
        supplier.setId(++index);
        supplierList.add(index, supplier);
        return supplier.toString();
    }

    @Override
    public String delete(int id) {
        logger.info("/inside the SupplierRepository.delete()");
        supplierList.remove(id);
        return "supplier removed";
    }

    @Override
    public List<Supplier> retrieve() {
        logger.info("/inside the SupplierRepository.retrieve()");
        return supplierList;
    }

    @Override
    public String search(int index) {
        logger.info("/inside the SupplierRepository.search()");
        return this.supplierList.get(index).toString();
    }

    @Override
    public String update(Supplier supplier) {
        logger.info("/inside the SupplierRepository.update()");

        // Checking if Name is neither null nor empty
        if (!(supplier.getName().isBlank() || supplier.getName().isEmpty())) {
            this.supplierList.get(Math.toIntExact(supplier.getId())).setName(supplier.getName());
        }

        // Checking if Contact Info is neither null nor empty
        if (supplier.getContactInfo().isBlank()|| supplier.getContactInfo().isEmpty()) {
            this.supplierList.get(Math.toIntExact(supplier.getId())).setContactInfo(supplier.getContactInfo());
        }

        return this.supplierList.get(Math.toIntExact(supplier.getId())).toString();
    }
}

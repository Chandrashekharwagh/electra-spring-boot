package com.electra.service;

import com.electra.domain.Supplier;
import com.electra.repository.SupplierRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    private static final Logger logger = LoggerFactory.getLogger(SupplierService.class);

    @Autowired
    private SupplierRepository repo;

    public List<Supplier> retrieveSuppliers() {
        logger.info("/inside the SupplierService.retrieveSuppliers()");
        return repo.retrieve();
    }

    public String storeSupplier(Supplier supplier) {
        logger.info("/inside the SupplierService.addSupplier()");;
        return repo.store(supplier);
    }

    public String deleteSupplier(int id) {
        logger.info("/inside the SupplierService.removeSupplier()");
        return repo.delete(id);
    }

    public String search(int id) {
        logger.info("/inside the SupplierService.search()");
        return repo.search(id);
    }

    public String updateSupplier(int id, Supplier supplier) {
        logger.info("/inside the SupplierService.updateSupplier()");
        supplier.setId(id);
        return repo.update(supplier);
    }

}

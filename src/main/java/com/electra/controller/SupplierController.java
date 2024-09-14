package com.electra.controller;

import com.electra.domain.Supplier;
import com.electra.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    //@RequestMapping(path = "/supplier", method = RequestMethod.GET)
    @GetMapping("/supplier")
    public List<Supplier> retrieveSuppliers() {
        return supplierService.retrieveSuppliers();
    }

    @GetMapping("/supplier/{supplierId}")
    public String retrieveSupplierForSupplierId(@PathVariable int supplierId) {
        return supplierService.search(supplierId);
    }

    @DeleteMapping("/supplier/{supplierId}")
    public String deleteSupplierForSupplierId(@PathVariable int supplierId) {
        return supplierService.deleteSupplier(supplierId);
    }

    @PostMapping("/supplier")
    public String addSupplier(@RequestBody Supplier supplier) {
        return supplierService.storeSupplier(supplier);
    }

    @PutMapping("/supplier/{supplierId}")
    public String updateSupplierForSupplierId(@PathVariable int supplierId, @RequestBody Supplier supplier) {
        return supplierService.updateSupplier(supplierId,supplier);
    }
}

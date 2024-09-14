package com.electra.repository;

import java.util.List;

public interface SupplierEntryRepository<Supplier> {
    public String store(Supplier supplier);

    public List<Supplier> retrieve();

    public String search(int id);

    public String delete(int id);

    public String update(Supplier supplier);
}

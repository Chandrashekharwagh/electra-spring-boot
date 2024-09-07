package com.electra.repository;

import java.util.List;

public interface BrandEntryRepository <Brand>{
    public String store(Brand brand);

    public List<Brand> retrieve();

    public String search(int id);

    public String delete(int id);

    public String update(Brand brand);
}

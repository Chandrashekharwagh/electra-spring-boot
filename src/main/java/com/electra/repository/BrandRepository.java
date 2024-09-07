package com.electra.repository;


import com.electra.domain.Brand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BrandRepository implements BrandEntryRepository<Brand>{
    private static final Logger logger = LoggerFactory.getLogger(BrandRepository.class);
    private List<Brand> brandList = new ArrayList<>();
    private int index = -1;

    public String store(Brand brand) {
        logger.info("/inside the BrandRepository.store()");
        brand.setId(++index);
        brandList.add(index, brand);
        return brand.toString();
    }

    @Override
    public String delete(int id) {
        logger.info("/inside the BrandRepository.delete()");
        brandList.remove(id);
        return "brand removed";
    }

    @Override
    public List<Brand> retrieve() {
        logger.info("/inside the BrandRepository.retrieve()");
        return brandList;
    }

    @Override
    public String search(int index) {
        logger.info("/inside the BrandRepository.search()");
        return this.brandList.get(index).toString();
    }

    @Override
    public String update(Brand brand) {
        logger.info("/inside the BrandRepository.update()");
        // Checking if Name is neither null nor empty
        if (!(brand.getName().isBlank() || brand.getName().isEmpty())) {
            this.brandList.get(brand.getId()).setName(brand.getName());
        }
        return this.brandList.get(brand.getId()).toString();
    }
}

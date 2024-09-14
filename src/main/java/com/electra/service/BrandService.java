package com.electra.service;

import com.electra.domain.Brand;
import com.electra.repository.BrandRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BrandService {
    private static final Logger logger = LoggerFactory.getLogger(BrandService.class);

    @Autowired
    private BrandRepository repo;

    public List<Brand> retrieveBrands() {
        logger.info("/inside the BrandService.retrieveBrands()");
        return repo.retrieve();
    }

    public String storeBrand(Brand brand) {
        logger.info("/inside the BrandService.addBrand()");;
        return repo.store(brand);
    }

    public String deleteBrand(int id) {
        logger.info("/inside the BrandService.removeBrand()");
        return repo.delete(id);
    }

    public String search(int id) {
        logger.info("/inside the BrandService.search()");
        return repo.search(id);
    }

    public String updateBrand(int id, Brand brand) {
        logger.info("/inside the BrandService.updateBrand()");
        brand.setId(id);
        return repo.update(brand);
    }
}

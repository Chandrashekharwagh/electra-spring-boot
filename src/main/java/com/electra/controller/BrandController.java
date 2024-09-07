package com.electra.controller;

import com.electra.domain.Brand;
import com.electra.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BrandController {
        @Autowired
        private BrandService brandService ;

        //@RequestMapping(path = "/brand", method = RequestMethod.GET)
        @GetMapping("/brand")
        public List<Brand> retrieveBrands() {
        return brandService.retrieveBrands();
    }

        @GetMapping("/brand/{brandId}")
        public String retrieveBrandForBrandId(@PathVariable int brandId) {
        return brandService.search(brandId);
    }

        @DeleteMapping("/brand/{brandId}")
        public String deleteBrandForBrandId(@PathVariable int brandId) {
        return brandService.deleteBrand(brandId);
    }

        @PostMapping("/brand")
        public String addBrand(@RequestBody Brand brand) {
        return brandService.storeBrand(brand);
    }

        @PutMapping("/brand/{brandId}")
        public String updateBrandForBrandId(@PathVariable int brandId, @RequestBody Brand brand) {
        return brandService.updateBrand(brandId, brand);
    }
}

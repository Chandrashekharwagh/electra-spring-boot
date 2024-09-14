package com.electra.controller;

import com.electra.domain.Address;
import com.electra.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;

    //@RequestMapping(path = "/address", method = RequestMethod.GET)
    @GetMapping("/address")
    public List<Address> retrieveAddresses() {
        return addressService.retrieveAddresses();
    }

    @GetMapping("/address/{addressId}")
    public String retrieveAddressForAddressId(@PathVariable int addressId) {
        return addressService.search(addressId);
    }

    @DeleteMapping("/address/{addressId}")
    public String deleteAddressForAddressId(@PathVariable int addressId) {
        return addressService.deleteAddress(addressId);
    }

    @PostMapping("/address")
    public String addAddress(@RequestBody Address address) {
        return addressService.storeAddress(address);
    }

    @PutMapping("/address/{addressId}")
    public String updateAddressForAddressId(@PathVariable int addressId, @RequestBody Address address) {
        return addressService.updateAddress(addressId, address);
    }
}

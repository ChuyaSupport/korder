package com.chuyasupport.kserver.controller;

import com.chuyasupport.kserver.entity.request.AddAddressRequest;
import com.chuyasupport.kserver.entity.response.AddAddressResponse;
import com.chuyasupport.kserver.service.Impl.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddAddressController {
    @Autowired
    private AddressServiceImpl addressService;
    @RequestMapping("/addAddress")
    public AddAddressResponse addAddress(@RequestBody AddAddressRequest addAddressRequest) {
     return addressService.addAddress(addAddressRequest);
    }
}

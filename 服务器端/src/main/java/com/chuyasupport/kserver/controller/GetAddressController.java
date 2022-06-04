package com.chuyasupport.kserver.controller;

import com.chuyasupport.kserver.service.Impl.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetAddressController {

    @Autowired
    private AddressServiceImpl addressService;

    @RequestMapping("/getAddress")
    public Object getAddress(@RequestParam String userId) {
        return addressService.getAddress(userId);
    }
}

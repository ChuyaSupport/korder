package com.chuyasupport.kserver.repository;

import com.chuyasupport.kserver.entity.pojo.Address;

import java.util.List;

public interface AddressRepository {
    List<Address> findAddressByUserId(String userId);
    int addAddress(Address address);
}

package com.chuyasupport.kserver.service;

import com.chuyasupport.kserver.entity.pojo.Address;
import com.chuyasupport.kserver.entity.request.AddAddressRequest;
import com.chuyasupport.kserver.entity.response.AddAddressResponse;
import com.chuyasupport.kserver.entity.response.AddressResponse;

public interface AddressService {
    AddressResponse getAddress(String userId);
    AddAddressResponse addAddress(AddAddressRequest addAddressRequest);
}

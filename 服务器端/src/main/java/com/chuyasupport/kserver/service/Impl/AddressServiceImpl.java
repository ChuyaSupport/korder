package com.chuyasupport.kserver.service.Impl;

import com.chuyasupport.kserver.entity.pojo.Address;
import com.chuyasupport.kserver.entity.request.AddAddressRequest;
import com.chuyasupport.kserver.entity.response.AddAddressResponse;
import com.chuyasupport.kserver.entity.response.AddressResponse;
import com.chuyasupport.kserver.repository.AddressRepository;
import com.chuyasupport.kserver.service.AddressService;
import com.chuyasupport.kserver.utils.DBUtil;
import com.chuyasupport.kserver.utils.UUID_16Util;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private Address address;

    private List<Address> addressList;

    @Override
    public AddressResponse getAddress(String userId) {
        SqlSession sqlSession = DBUtil.getSession();
        AddressRepository addressRepository = sqlSession.getMapper(AddressRepository.class);

        try {
            addressList = addressRepository.findAddressByUserId(userId);
        }catch (Exception e) {
            e.printStackTrace();
        }
        if(addressList != null) {
            AddressResponse addressResponse = new AddressResponse();
            addressResponse.setAddressList(addressList);
            addressResponse.setStatus(0);
            return addressResponse;
        }

        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setStatus(-1);
        return addressResponse;
    }

    @Override
    public AddAddressResponse addAddress(AddAddressRequest addAddressRequest) {
        int status = 0;
        address.setAddrId(UUID_16Util.get16UUID());
        address.setUserId(addAddressRequest.getUserId());
        address.setUserName(addAddressRequest.getUserName());
        address.setGender(addAddressRequest.getGender());
        address.setAddress(addAddressRequest.getAddress());
        address.setPhoneNumber(addAddressRequest.getPhoneNumber());

        SqlSession sqlSession = DBUtil.getSession();
        AddressRepository addressRepository = sqlSession.getMapper(AddressRepository.class);

        try {
            status = addressRepository.addAddress(address);
            sqlSession.commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
        AddAddressResponse addressResponse = new AddAddressResponse();
        int code = status > 0 ? 0 : -1;
        addressResponse.setStatus(code);
        return addressResponse;
    }
}

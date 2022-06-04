package com.chuyasupport.kserver.entity.response;

import com.chuyasupport.kserver.entity.pojo.Address;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class AddressResponse {
    private int status;
    private List<Address> addressList;
}

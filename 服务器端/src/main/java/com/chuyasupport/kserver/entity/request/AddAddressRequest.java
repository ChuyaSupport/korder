package com.chuyasupport.kserver.entity.request;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class AddAddressRequest {
    private String userName;
    private String gender;
    private String address;
    private String phoneNumber;
    private String userId;

}

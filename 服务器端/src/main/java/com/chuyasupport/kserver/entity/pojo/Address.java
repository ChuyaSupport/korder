package com.chuyasupport.kserver.entity.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Address {
    private String addrId;
    private String UserId;
    private String UserName;
    private String gender;
    private String address;
    private String phoneNumber;
}

package com.chuyasupport.kserver.entity.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Data
@Component
public class User {
    private String userId;
    private String userName;
    private String avartarUrl;
    private String phoneNumber;
    private String password;
    private BigDecimal balance;
    private String gender;
}

package com.chuyasupport.kserver.entity.response;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Data
@Component
public class LoginResponse {
    private String avartarUrl;
    private String userId;
    private String userName;
    private String phoneNumber;
    private BigDecimal balance;
    private String gender;
    private String password;
    private int status;
}

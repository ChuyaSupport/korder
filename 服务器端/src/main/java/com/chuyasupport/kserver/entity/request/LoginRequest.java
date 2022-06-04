package com.chuyasupport.kserver.entity.request;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class LoginRequest {
    private String phoneNumber;
    private String password;
}

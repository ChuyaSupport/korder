package com.chuyasupport.kserver.service;

import com.chuyasupport.kserver.entity.request.LoginRequest;
import com.chuyasupport.kserver.entity.response.LoginResponse;

public interface LoginService {
    LoginResponse login(LoginRequest loginRequest);
}

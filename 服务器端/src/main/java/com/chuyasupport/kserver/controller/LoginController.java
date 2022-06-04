package com.chuyasupport.kserver.controller;

import com.chuyasupport.kserver.entity.request.LoginRequest;
import com.chuyasupport.kserver.entity.response.LoginResponse;
import com.chuyasupport.kserver.service.Impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginServiceImpl loginService;
    @RequestMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return loginService.login(loginRequest);
    }
}

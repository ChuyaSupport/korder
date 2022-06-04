package com.chuyasupport.kserver.controller;

import com.chuyasupport.kserver.entity.response.MyGetResponse;
import com.chuyasupport.kserver.service.Impl.MyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyGetController {
    @Autowired
    private MyServiceImpl myService;
    @RequestMapping("/myGet")
    public MyGetResponse getMyGet(@RequestParam String userId) {

        return myService.getMyGet(userId);
    }
}

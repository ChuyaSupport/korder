package com.chuyasupport.kserver.controller;

import com.chuyasupport.kserver.entity.response.MyPostResponse;
import com.chuyasupport.kserver.service.Impl.MyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyPostController {
    @Autowired
    private MyServiceImpl myService;
    @RequestMapping("/getMyPost")
    public MyPostResponse getMyPost(@RequestParam String userId) {
        return myService.getMyPost(userId);
    }
}

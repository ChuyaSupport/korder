package com.chuyasupport.kserver.controller;

import com.chuyasupport.kserver.entity.response.FindResponse;
import com.chuyasupport.kserver.service.Impl.FindServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FindController {

    @Autowired
    private FindServiceImpl findService;

    @RequestMapping("/find")
    public FindResponse getFind() {
        return findService.getFindData();
    }
}

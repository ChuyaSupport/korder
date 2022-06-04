package com.chuyasupport.kserver.controller;

import com.chuyasupport.kserver.entity.view.VFindDetail;
import com.chuyasupport.kserver.service.Impl.FindServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindDetailController {
    @Autowired
    private FindServiceImpl findService;
    @RequestMapping("/findDetail")
    public VFindDetail getFindDetail(@RequestParam String postId) {

        return findService.getFindFetail(postId);
    }
}

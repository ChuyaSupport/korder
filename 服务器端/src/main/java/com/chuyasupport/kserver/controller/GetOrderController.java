package com.chuyasupport.kserver.controller;

import com.chuyasupport.kserver.entity.response.GetOrderResponse;
import com.chuyasupport.kserver.service.Impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetOrderController {

    @Autowired
    private OrderServiceImpl orderService;
    @RequestMapping("/receive")
    public GetOrderResponse getOrder(@RequestParam String userId, @RequestParam String postId) {
        return orderService.getOrder(userId, postId);
    }
}

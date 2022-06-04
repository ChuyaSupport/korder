package com.chuyasupport.kserver.service;

import com.chuyasupport.kserver.entity.response.GetOrderResponse;
import org.springframework.stereotype.Service;


public interface OrderService {
    GetOrderResponse getOrder(String userId, String postId);
    int confirm(String postId);
}

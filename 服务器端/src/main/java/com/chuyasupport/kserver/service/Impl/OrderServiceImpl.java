package com.chuyasupport.kserver.service.Impl;

import com.chuyasupport.kserver.entity.response.GetOrderResponse;
import com.chuyasupport.kserver.repository.OrderRepository;
import com.chuyasupport.kserver.service.OrderService;
import com.chuyasupport.kserver.utils.DBUtil;
import com.chuyasupport.kserver.utils.UUID_16Util;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public GetOrderResponse getOrder(String userId, String postId) {

        String receiveId = UUID_16Util.get16UUID();
        int status = 0;
        SqlSession sqlSession = DBUtil.getSession();
        OrderRepository orderRepository = sqlSession.getMapper(OrderRepository.class);

        try {
            status = orderRepository.addGetOrder(receiveId, userId, postId);
            orderRepository.setOrderReceived(postId);
            sqlSession.commit();
        }catch (Exception e) {
            e.printStackTrace();
        }

        GetOrderResponse getOrderResponse = new GetOrderResponse();
        status = status > 0 ? 0 : -1;
        getOrderResponse.setStatus(String.valueOf(status));

        return getOrderResponse;
    }

    @Override
    public int confirm(String postId) {
        SqlSession sqlSession = DBUtil.getSession();
        OrderRepository orderRepository = sqlSession.getMapper(OrderRepository.class);
        int status = 0;

        try {
            status = orderRepository.confirm(postId);
            sqlSession.commit();
        }catch (Exception e) {
            e.printStackTrace();
        }

        status = status > 0 ? 0 : -1;

        return status;
    }
}

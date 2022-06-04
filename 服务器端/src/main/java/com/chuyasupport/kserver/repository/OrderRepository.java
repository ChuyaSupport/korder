package com.chuyasupport.kserver.repository;

import org.apache.ibatis.annotations.Param;

public interface OrderRepository {
    int addGetOrder(@Param("receiveId") String receive_id, @Param("userId") String userId, @Param("postId") String postId);
    int setOrderReceived(String postId);
    int confirm(String postId);
}

package com.chuyasupport.kserver.service;

import com.chuyasupport.kserver.entity.response.MyGetResponse;
import com.chuyasupport.kserver.entity.response.MyPostResponse;

public interface MyService {
    MyGetResponse getMyGet(String userId);
    MyPostResponse getMyPost(String userId);

}

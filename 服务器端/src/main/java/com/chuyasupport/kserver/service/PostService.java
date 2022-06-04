package com.chuyasupport.kserver.service;

import com.chuyasupport.kserver.entity.request.PostRequest;
import com.chuyasupport.kserver.entity.response.PostResponse;

public interface PostService {
    PostResponse post(PostRequest postRequest);
}

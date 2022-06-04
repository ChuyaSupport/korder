package com.chuyasupport.kserver.repository;

import com.chuyasupport.kserver.entity.pojo.Post;
import com.chuyasupport.kserver.entity.request.PostRequest;

public interface PostRepository {
    int post(Post post);
}

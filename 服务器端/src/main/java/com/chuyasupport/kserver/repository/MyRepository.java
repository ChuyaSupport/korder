package com.chuyasupport.kserver.repository;

import com.chuyasupport.kserver.entity.view.VMyGet;
import com.chuyasupport.kserver.entity.view.VMyPost;

import java.util.List;

public interface MyRepository {
    List<VMyGet> getMyGet(String userId);
    List<VMyPost> getMyPost(String userId);
}

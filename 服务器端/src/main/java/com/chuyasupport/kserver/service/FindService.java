package com.chuyasupport.kserver.service;

import com.chuyasupport.kserver.entity.response.FindResponse;
import com.chuyasupport.kserver.entity.view.VFindDetail;

import java.util.List;

public interface FindService {
    FindResponse getFindData();
    VFindDetail getFindFetail(String postId);
}

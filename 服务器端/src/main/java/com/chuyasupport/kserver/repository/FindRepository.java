package com.chuyasupport.kserver.repository;

import com.chuyasupport.kserver.entity.view.VFindDetail;
import com.chuyasupport.kserver.entity.view.VFindResponse;

import java.util.List;

public interface FindRepository {
    List<VFindResponse> getFindData();
    VFindDetail getFindDetail(String postId);
}

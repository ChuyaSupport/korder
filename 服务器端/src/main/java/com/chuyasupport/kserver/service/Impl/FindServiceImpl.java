package com.chuyasupport.kserver.service.Impl;

import com.chuyasupport.kserver.entity.response.FindResponse;
import com.chuyasupport.kserver.entity.view.VFindDetail;
import com.chuyasupport.kserver.entity.view.VFindResponse;
import com.chuyasupport.kserver.repository.FindRepository;
import com.chuyasupport.kserver.service.FindService;
import com.chuyasupport.kserver.utils.DBUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindServiceImpl implements FindService {
    @Override
    public FindResponse getFindData() {
        SqlSession sqlSession = DBUtil.getSession();
        FindRepository findRepository = sqlSession.getMapper(FindRepository.class);
        List<VFindResponse> vFindResponseList = null;

        try {
            vFindResponseList= findRepository.getFindData();
        }catch (Exception e) {
            e.printStackTrace();
        }

        FindResponse findResponse = new FindResponse();
        if(vFindResponseList != null) {
            findResponse.setStatus(0);
            findResponse.setVFindResponseList(vFindResponseList);
            return findResponse;
        }
        findResponse.setStatus(-1);

        return findResponse;
    }

    @Override
    public VFindDetail getFindFetail(String postId) {
        VFindDetail vFindDetail = null;
        SqlSession sqlSession = DBUtil.getSession();
        FindRepository findRepository = sqlSession.getMapper(FindRepository.class);

        try {
            vFindDetail = findRepository.getFindDetail(postId);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return vFindDetail;
    }
}

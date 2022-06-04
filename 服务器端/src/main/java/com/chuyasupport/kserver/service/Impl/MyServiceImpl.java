package com.chuyasupport.kserver.service.Impl;

import com.chuyasupport.kserver.entity.response.MyGetResponse;
import com.chuyasupport.kserver.entity.response.MyPostResponse;
import com.chuyasupport.kserver.entity.view.VMyGet;
import com.chuyasupport.kserver.entity.view.VMyPost;
import com.chuyasupport.kserver.repository.MyRepository;
import com.chuyasupport.kserver.service.MyService;
import com.chuyasupport.kserver.utils.DBUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyServiceImpl implements MyService {

    private List<VMyGet> vMyGetList;
    private List<VMyPost> vMyPostList;
    @Override
    public MyGetResponse getMyGet(String userId) {
        SqlSession sqlSession = DBUtil.getSession();
        MyRepository myRepository = sqlSession.getMapper(MyRepository.class);

        try {
            vMyGetList = myRepository.getMyGet(userId);
        }catch (Exception e) {
            e.printStackTrace();
        }

        MyGetResponse myGetResponse = new MyGetResponse();
        myGetResponse.setStatus("0");
        myGetResponse.setVMyGetList(vMyGetList);
        return myGetResponse;
    }

    @Override
    public MyPostResponse getMyPost(String userId) {

        SqlSession sqlSession = DBUtil.getSession();
        MyRepository myRepository = sqlSession.getMapper(MyRepository.class);
        try {
            vMyPostList = myRepository.getMyPost(userId);
        }catch (Exception e) {
            e.printStackTrace();
        }
        MyPostResponse myPostResponse = new MyPostResponse();
        myPostResponse.setStatus("0");
        myPostResponse.setVMyPostList(vMyPostList);
        return myPostResponse;
    }
}

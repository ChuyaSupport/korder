package com.chuyasupport.kserver.service.Impl;

import com.chuyasupport.kserver.entity.pojo.Post;
import com.chuyasupport.kserver.entity.request.PostRequest;
import com.chuyasupport.kserver.entity.response.PostResponse;
import com.chuyasupport.kserver.repository.PostRepository;
import com.chuyasupport.kserver.service.PostService;
import com.chuyasupport.kserver.utils.DBUtil;
import com.chuyasupport.kserver.utils.UUID_16Util;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Override
    public PostResponse post(PostRequest postRequest) {

        int status = 0;
        SqlSession sqlSession = DBUtil.getSession();
        PostRepository postRepository = sqlSession.getMapper(PostRepository.class);

        Post post = new Post();
        post.setPostId(UUID_16Util.get16UUID());
        post.setUserId(postRequest.getUserId());
        post.setPackageCode(postRequest.getPackageCode());
        post.setGetAddr(postRequest.getGetAddr());
        post.setAddrId(postRequest.getAddrId());
        post.setPackageSize(postRequest.getPackageSize());
        post.setReward(postRequest.getReward());

        try {
            status = postRepository.post(post);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        PostResponse postResponse = new PostResponse();
        status = status > 0 ? 0 : -1;
        postResponse.setStatus(String.valueOf(status));
        return postResponse;
    }
}

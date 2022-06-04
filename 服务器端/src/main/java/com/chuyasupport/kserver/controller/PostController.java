package com.chuyasupport.kserver.controller;

import com.chuyasupport.kserver.entity.request.PostRequest;
import com.chuyasupport.kserver.entity.response.PostResponse;
import com.chuyasupport.kserver.service.Impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired
    private PostServiceImpl postService;

    @RequestMapping("/post")
    public PostResponse post(@RequestBody PostRequest postRequest) {
        return postService.post(postRequest);
    }
}

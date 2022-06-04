package com.chuyasupport.kserver.entity.response;

import com.chuyasupport.kserver.entity.view.VMyPost;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class MyPostResponse {
    private String status;
    private List<VMyPost> vMyPostList;
}

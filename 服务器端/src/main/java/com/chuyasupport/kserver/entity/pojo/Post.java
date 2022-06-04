package com.chuyasupport.kserver.entity.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Post {
    private String postId;
    private String userId;
    private String packageCode;
    private String getAddr;
    private String addrId;
    private String packageSize;
    private String reward;
    private String status;
}

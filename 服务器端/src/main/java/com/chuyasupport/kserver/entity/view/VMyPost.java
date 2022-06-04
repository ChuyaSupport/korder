package com.chuyasupport.kserver.entity.view;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class VMyPost {
    private String getAddr;
    private String packageCode;
    private String packageSize;
    private String reward;
    private String status;
    private String userName;
    private String address;
    private String phoneNumber;
    private String userId;
    private String postId;
}

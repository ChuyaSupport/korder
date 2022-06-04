package com.chuyasupport.kserver.entity.view;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class VMyGet {
    private String userId;
    private String getAddr;
    private String packageCode;
    private String userName;
    private String phoneNumber;
    private String packageSize;
    private String reward;
    private String postId;
    private String address;
    private int status;
}

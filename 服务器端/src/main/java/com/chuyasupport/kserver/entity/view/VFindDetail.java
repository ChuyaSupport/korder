package com.chuyasupport.kserver.entity.view;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class VFindDetail {
    private String postId;
    private String getAddr;
    private String reward;
    private String packageSize;
    private String packageCode;
    private String address;
    private String userName;
    private String gender;
    private String phoneNumber;
}

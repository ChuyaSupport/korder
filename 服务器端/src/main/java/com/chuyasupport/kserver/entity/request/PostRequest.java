package com.chuyasupport.kserver.entity.request;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PostRequest {
    private String userId;
    private String packageCode;
    private String getAddr;
    private String addrId;
    private String packageSize;
    private String reward;
}

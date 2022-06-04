package com.chuyasupport.kserver.entity.view;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class VFindResponse {
    private String postId;
    private String getAddr;
    private String packageSize;
    private String address;
    private String reward;
}

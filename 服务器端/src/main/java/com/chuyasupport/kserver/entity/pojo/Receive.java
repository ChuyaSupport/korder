package com.chuyasupport.kserver.entity.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Receive {
    private String receiveId;
    private String postId;
    private String userId;
}

package com.chuyasupport.kserver.entity.response;

import com.chuyasupport.kserver.entity.view.VMyGet;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class MyGetResponse {
    private String status;
    List<VMyGet> vMyGetList;
}

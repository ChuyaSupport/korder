package com.chuyasupport.kserver.entity.response;

import com.chuyasupport.kserver.entity.view.VFindResponse;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Data
public class FindResponse {
    private int status;
    private List<VFindResponse> vFindResponseList;
}

package com.chuyasupport.kserver;

import com.chuyasupport.kserver.entity.pojo.User;
import com.chuyasupport.kserver.repository.UserRepository;
import com.chuyasupport.kserver.utils.DBUtil;
import com.chuyasupport.kserver.utils.GUIDUtil;
import com.chuyasupport.kserver.utils.UUID_16Util;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class TestController {

    @Test
    public void testDemo() {
        System.out.println("UUID = " + UUID_16Util.get16UUID());
        System.out.println("GUID = " + GUIDUtil.getGUID());
    }

}

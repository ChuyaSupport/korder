package com.chuyasupport.kserver.service.Impl;

import com.chuyasupport.kserver.entity.pojo.User;
import com.chuyasupport.kserver.entity.request.LoginRequest;
import com.chuyasupport.kserver.entity.response.LoginResponse;
import com.chuyasupport.kserver.repository.UserRepository;
import com.chuyasupport.kserver.service.LoginService;
import com.chuyasupport.kserver.utils.DBUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    private User user;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse();
        if(loginRequest != null) {
            SqlSession sqlSession = DBUtil.getSession();
            UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
            try {
                user = userRepository.findUserByPhoneNumber(loginRequest.getPhoneNumber());
            }catch (Exception e) {
                e.printStackTrace();
            }
            if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
                loginResponse.setAvartarUrl(user.getAvartarUrl());
                loginResponse.setUserId(user.getUserId());
                loginResponse.setUserName(user.getUserName());
                loginResponse.setPhoneNumber(user.getPhoneNumber());
                loginResponse.setBalance(user.getBalance());
                loginResponse.setGender(user.getGender());
                loginResponse.setPassword(user.getPassword());
                loginResponse.setStatus(0);
                return loginResponse;
            }
        }
        loginResponse.setStatus(-1);
        return loginResponse;
    }
}

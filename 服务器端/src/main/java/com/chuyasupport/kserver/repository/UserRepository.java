package com.chuyasupport.kserver.repository;

import com.chuyasupport.kserver.entity.pojo.User;

public interface UserRepository {
    User findUserByPhoneNumber(String phoneNumber);
}

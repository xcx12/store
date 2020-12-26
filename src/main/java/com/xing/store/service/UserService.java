package com.xing.store.service;

import com.xing.store.pojo.entity.User;

public interface UserService {
    boolean login(User user);



    User getuserByPhone(String phone);


    int addUsers(User user);
}

package com.xing.store.service.impl;

import com.xing.store.dao.UserDao;

import com.xing.store.pojo.entity.User;
import com.xing.store.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Resource

    UserDao userDao;
    @Override
    public boolean login(User user) {
        User user1= userDao.selectByPhone(user.getPhone());

        if (user1==null){
            return false;
        }
        else{
            if (user.getPassword()==null){
                return false;

            }
            if (user.getPassword().equals(user1.getPassword())){
                return true;
            }
        }
        return false;
    }

    @Override
    public User getuserByPhone(String phone) {

        return userDao.selectByPhone(phone);
    }

    @Override
    public int addUsers(User user) {
        return userDao.insert(user);
    }


}

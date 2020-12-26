package com.xing.store.controller;

import com.xing.store.dao.UserDao;
import com.xing.store.pojo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class IndexController {
    @Resource
    UserDao userDao;

    @RequestMapping("/")

    //表示返回json字符串给前端
    String index() {

        return "index";
    }

}

package com.xing.store.controller.pages.front;

import com.xing.store.pojo.entity.User;
import com.xing.store.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/pages/front")
public class LoginController{

    @Resource
    UserService userService;


    @RequestMapping("loginPage")
    String loginPage(){
        return "pages/front/login/loginPage";
    }

    @RequestMapping("login")
    String login(User user, Model model, HttpSession session){
        if("".equals(user.getPhone())||user.getPhone()==null){

        model.addAttribute("erroMsg","请输入正确手机号！");
        return "pages/front/login/loginPage";
        }

        boolean loginResult= userService.login(user);

        model.addAttribute("erroMsg","登录失败，手机或密码错误");
        return "pages/front/login/loginPage";
    }

    @RequestMapping("regist")
    String regist(){
        return "pages/front/login/regist";
    }

    @RequestMapping("doregist")

    public String doregist(User user, Model model) {
        if("".equals(user.getPhone())||user.getPhone()==null || user.getPassword()==null){

            model.addAttribute("erroMsg","请输入手机号！");
            return "pages/front/login/regist";
        }else {
            user.setName(user.getName());
            user.setPhone(user.getPhone());
            user.setPassword(user.getPassword());
            int i=userService.addUsers(user);
            if(i==1){
                return "pages/front/regist";
            }else {
                return "pages/front/login/regist";
            }
        }



    }
}

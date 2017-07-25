package com.example.studentms.controller;

import com.example.studentms.entity.User;
import com.example.studentms.service.UserService;
import com.example.studentms.util.MD5Util;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hehaoneng on 2017/7/19.
 */
@Controller
@RequestMapping("/")
public class UserController {
    private static final Logger LOGGER = Logger.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping("/login.do")
    public String login(ModelMap map ,String username, String password){
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            return "/error";
        }
        User user = userService.getFromUsername(username);
        String encryptPsw = MD5Util.getMD5(password);
        if (encryptPsw.equals(user.getPassword())) {
            map.addAttribute("username",username);
            return "/main";
        }
        return "/error";
    }

    @RequestMapping("/main")
    public String main(){
        return "/main";
    }

    @RequestMapping("/updatePsw")
    public String updatePsw(){
        return "/updatePsw";
    }

    @RequestMapping("/hello")
    public @ResponseBody String hello() {
        return "hello, world! This com from spring!";
    }
}

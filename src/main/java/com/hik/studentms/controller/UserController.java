package com.hik.studentms.controller;

import com.hik.studentms.entity.Student;
import com.hik.studentms.entity.User;
import com.hik.studentms.service.StudentService;
import com.hik.studentms.service.UserService;
import com.hik.studentms.util.MD5Util;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    public String login(String username, String password){
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            return "/error";
        }
        User user = userService.getFromUsername(username);
        String encryptPsw = MD5Util.getMD5(password);
        if (encryptPsw.equals(user.getPassword())) {
            return "/home/index";
        }
        return "/error";
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

package com.hik.studentms.controller;

import com.hik.studentms.entity.Student;
import com.hik.studentms.entity.User;
import com.hik.studentms.service.StudentService;
import com.hik.studentms.service.UserService;
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
@RequestMapping("/student")
public class StudentController {
    private static final Logger LOGGER = Logger.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;
    @Autowired
    UserService userService;

    @RequestMapping("/student/{id}")
    public String showStudentInfo(ModelMap modelMap, @PathVariable String studentId){
        LOGGER.info("查询用户：" + studentId);
        Student student=studentService.load(studentId);
        modelMap.addAttribute("studentInfo", student);
        return "/student/showAllStudents";
    }

    @RequestMapping("/showStudents")
    public @ResponseBody
    List<Student> showUserInfos(){
        LOGGER.info("查询用户全部用户");
        List<Student> students = studentService.findAll();
        return students;
    }

    @RequestMapping("/add")
    public String add(){
        return "/student/add";
    }

    @RequestMapping("/display")
    public String display(){
        return "/student/display";
    }

    @RequestMapping("/showAllStudents")
    public String showAllStudents(){
        return "/student/showAllStudents";
    }

    @RequestMapping("/update")
    public String update(){
        return "/student/update";
    }

    @RequestMapping("/hello")
    public @ResponseBody String test() {
        return "hello, world! This com from spring!";
    }
}

package com.example.studentms.controller;

import com.example.studentms.service.StudentService;
import com.example.studentms.service.UserService;
import com.example.studentms.util.IdUtil;
import com.example.studentms.entity.Student;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @RequestMapping("/showStudents")
    public @ResponseBody List<Student> showUserInfos(){
        LOGGER.info("查询用户全部用户");
        List<Student> students = studentService.findAll();
        return students;
    }

    @RequestMapping("/add")
    public String add(){
        return "/student/add";
    }

    @RequestMapping("/add.do")
    public String addStudent(String name, int gender, float balance, String address ){
        Student student = new Student();
        student.setId(IdUtil.generateId());
        student.setAddress(address);
        student.setName(name);
        student.setGender(gender);
        student.setBalance(balance);
        String msg = studentService.save(student);
        return "forward:/student/display";
    }

    @RequestMapping("/display")
    public String display(ModelMap model){
        model.addAttribute("students", studentService.findAll());
        return "/student/display";
    }

    @RequestMapping("/search.do")
    public String search(ModelMap model, @RequestParam String name){
        if (name == null || name.isEmpty()) {
            return display(model);
        }
        model.addAttribute("students", studentService.search(name));
        return "/student/display";
    }

    @RequestMapping("/update")
    public String update(ModelMap model, @RequestParam String id){
        Student student = studentService.load(id);
        model.addAttribute("student", student);
        return "/student/update";
    }

    @RequestMapping("/update.do")
    public String updateStudent(String id, String name, int gender, float balance, String address ){
        Student student = new Student();
        student.setId(id);
        student.setAddress(address);
        student.setName(name);
        student.setGender(gender);
        student.setBalance(balance);
        studentService.saveOrUpdate(student);
        return "redirect:/student/display";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam String id) {
        studentService.delete(id);
        return "redirect:/student/display";
    }

    @RequestMapping("/main")
    public @ResponseBody String main() {
        return "redirect:/main";
    }
}

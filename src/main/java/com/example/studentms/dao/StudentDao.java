package com.example.studentms.dao;

import com.example.studentms.entity.Student;

import java.util.List;

/**
 * Created by hehaoneng on 2017/7/19.
 */
public interface StudentDao extends GenericDao<Student, String>{
    List<Student> search(String name);
}

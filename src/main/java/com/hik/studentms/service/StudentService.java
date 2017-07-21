package com.hik.studentms.service;

import com.hik.studentms.entity.Student;

import java.util.List;

/**
 * Created by hehaoneng on 2017/7/19.
 */
public interface StudentService {

    Student load(String id);

    Student get(String id);

    List<Student> findAll();

    void persist(Student student);

    String save(Student student);

    void saveOrUpdate(Student student);

    void delete(String id);

    void flush();
}

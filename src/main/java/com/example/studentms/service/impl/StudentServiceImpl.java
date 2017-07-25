package com.example.studentms.service.impl;

import com.example.studentms.dao.StudentDao;
import com.example.studentms.entity.Student;
import com.example.studentms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hehaoneng on 2017/7/19.
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao studentDao;

    @Override
    public Student load(String id) {
        return studentDao.loadFromId(id);
    }

    @Override
    public Student get(String id) {
        return studentDao.getFromId(id);
    }

    @Override
    public List<Student> search(String name) {
        return studentDao.search(name);
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public void persist(Student student) {
        studentDao.persist(student);
    }

    @Override
    public String save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public void saveOrUpdate(Student student) {
        studentDao.saveOrUpdate(student);
    }

    @Override
    public void delete(String id) {
        studentDao.deleteFromId(id);
    }

    @Override
    public void flush() {
        studentDao.flush();
    }
}

package com.example.studentms.dao.impl;

import com.example.studentms.dao.StudentDao;
import com.example.studentms.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hehaoneng on 2017/7/19.
 */
@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {

    @Autowired
    SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public Student loadFromId(String id) {
        return (Student) this.getCurrentSession().load(Student.class, id);
    }

    @Override
    public Student getFromId(String id) {
        return (Student) this.getCurrentSession().get(Student.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Student> findAll() {
        String queryString = "from Student";
        return this.getCurrentSession().createQuery(queryString).setCacheable(true).list();
    }

    @Override
    public void persist(Student entity) {
        this.getCurrentSession().persist(entity);
    }

    @Override
    public String save(Student student) {
        String rseult = "";
        Session session = sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();
        rseult = (String) session.save(student);
        transaction.commit();
        session.close();

        return  rseult;
    }

    @Override
    public void saveOrUpdate(Student student) {
        Session session = sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();
        session.update(student);
        transaction.commit();
        session.close();
//        this.getCurrentSession().saveOrUpdate(student);
    }

    @Override
    public void deleteFromId(String id) {
        Student student = this.loadFromId(id);
//        this.getCurrentSession().delete(student);
        Session session = sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();
        session.delete(student);
        transaction.commit();
        session.close();
    }

    @Override
    public void flush() {
        this.getCurrentSession().flush();
    }
}

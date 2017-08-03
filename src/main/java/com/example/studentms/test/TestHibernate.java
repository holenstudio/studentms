package com.example.studentms.test;

import com.example.studentms.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestHibernate {

    public Session buildConfiguration(Class<?> clazz) {
        Configuration cfg = new Configuration();
        cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        cfg.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        cfg.setProperty("hibernate.connection.url","jdbc:postgresql://127.0.0.1:5432/studentms");
        cfg.setProperty("hibernate.connection.username", "postgres");
        cfg.setProperty("hibernate.connection.password", "ABC1616abc");

        cfg.setProperty("hibernate.current_session_context_class", "thread");   //与当前线程绑定
        cfg.addAnnotatedClass(clazz);
        SessionFactory sf = cfg.buildSessionFactory();
        return sf.getCurrentSession();
    }

    public  void testDelete() {
        Session session = buildConfiguration(Student.class);

        Transaction tx = session.getTransaction();
        tx.begin();
        Student stu = (Student) session.load(Student.class,"4605fc6f-3434-4ba1-9060-15eba8703065");
        System.out.println(stu.getAddress());
        session.delete(stu);
        tx.commit();
    }

}

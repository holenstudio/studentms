package com.example.studentms.dao.impl;

import com.example.studentms.dao.UserDao;
import com.example.studentms.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hehaoneng on 2017/7/19.
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public User loadFromId(String id) {
        return (User) this.getCurrentSession().load(User.class, id);
    }

    @Override
    public User getFromId(String id) {
        return (User) this.getCurrentSession().get(User.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> findAll() {
        String queryString = "from User";
        return this.getCurrentSession().createQuery(queryString).setCacheable(true).list();
    }

    @Override
    public void persist(User entity) {
        this.getCurrentSession().persist(entity);
    }

    @Override
    public String save(User user) {
        return (String) this.getCurrentSession().save(user);
    }

    @Override
    public void saveOrUpdate(User entity) {
        this.getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void deleteFromId(String id) {
        User user = this.loadFromId(id);
        this.getCurrentSession().delete(user);
    }

    @Override
    public void flush() {
        this.getCurrentSession().flush();
    }

    @Override
    public User loadFromUsername(String username) {
        String hql = "from User as u where u.username=?";
        List<User> users = this.getCurrentSession().createQuery(hql).setString(0, username).list();
        if (users == null || users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    @Override
    public User getFromUsername(String username) {
        return this.loadFromUsername(username);
    }

    @Override
    public void deleteFromUsername(String username) {
        String hql = "from User as u where u.username=?";
        List<User> users = this.getCurrentSession().createQuery(hql).setString(0, username).list();
        if (users == null || users.isEmpty()) {
            return;
        }
        this.getCurrentSession().delete(users.get(0));
    }
}

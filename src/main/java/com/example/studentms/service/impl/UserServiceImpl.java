package com.example.studentms.service.impl;

import com.example.studentms.dao.UserDao;
import com.example.studentms.entity.User;
import com.example.studentms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hehaoneng on 2017/7/19.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User loadFromId(String id) {
        return userDao.loadFromId(id);
    }

    @Override
    public User getFromId(String id) {
        return userDao.getFromId(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void persist(User User) {
        userDao.persist(User);
    }

    @Override
    public String save(User User) {
        return userDao.save(User);
    }

    @Override
    public void saveOrUpdate(User User) {
        userDao.saveOrUpdate(User);
    }

    @Override
    public void deleteFromId(String id) {
        userDao.deleteFromId(id);
    }

    @Override
    public void flush() {
        userDao.flush();
    }

    @Override
    public User loadFromUsername(String username) {
        return userDao.loadFromUsername(username);
    }

    @Override
    public User getFromUsername(String username) {
        return userDao.getFromUsername(username);
    }

    @Override
    public void deleteFromUsername(String username) {
        userDao.deleteFromUsername(username);
    }
}

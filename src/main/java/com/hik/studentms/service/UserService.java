package com.hik.studentms.service;

import com.hik.studentms.entity.User;

import java.util.List;

/**
 * Created by hehaoneng on 2017/7/19.
 */
public interface UserService {

    User loadFromId(String id);

    User getFromId(String id);

    List<User> findAll();

    void persist(User user);

    String save(User user);

    void saveOrUpdate(User user);

    void deleteFromId(String id);

    void flush();

    User loadFromUsername(String username);

    User getFromUsername(String username);

    void deleteFromUsername(String username);
}

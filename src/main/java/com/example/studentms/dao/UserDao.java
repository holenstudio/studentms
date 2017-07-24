package com.example.studentms.dao;

import com.example.studentms.entity.User;

/**
 * Created by hehaoneng on 2017/7/19.
 */
public interface UserDao extends GenericDao<User, String>{

    User loadFromUsername(String username);

    User getFromUsername(String username);

    void deleteFromUsername(String username);
}

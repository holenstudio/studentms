package com.hik.studentms.dao;

import com.hik.studentms.entity.User;

/**
 * Created by hehaoneng on 2017/7/19.
 */
public interface UserDao extends GenericDao<User, String>{

    User loadFromUsername(String username);

    User getFromUsername(String username);

    void deleteFromUsername(String username);
}

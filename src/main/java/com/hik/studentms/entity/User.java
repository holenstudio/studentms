package com.hik.studentms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by hehaoneng on 2017/7/19.
 */
@Entity
@Table(name = "user_info")
public class User implements Serializable{

    private static final long serialVersionUID = -2906012211809211578L;
    String id;
    String username;
    String password;
    int identity;

    @Id
    @Column(name = "id", unique = true, nullable = false, length = 36)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "username", nullable = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", nullable = true)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "identity", nullable = false)
    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int gender) {
        this.identity = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", identity=" + identity +
                '}';
    }
}

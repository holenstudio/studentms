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
@Table(name = "student_info")
public class Student implements Serializable{
    private static final long serialVersionUID = -3417704505579858409L;
    String id;
    String username;
    int gender;
    String address;
    float balance;

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


    @Column(name = "gender", nullable = false)
    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Column(name = "address", nullable = false)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "balance", nullable = false)
    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", balance=" + balance +
                '}';
    }
}

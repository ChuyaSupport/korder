package com.chuyasupport.kclient.entity.pojo;

import java.math.BigDecimal;

public class User {
    private String user_id;
    private String user_name;
    private String avartar_url;
    private String phone_number;
    private String balance;
    private String gender;
    private String password;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getAvartar_url() {
        return avartar_url;
    }

    public void setAvartar_url(String avartar_url) {
        this.avartar_url = avartar_url;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", avartar_url='" + avartar_url + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", balance=" + balance +
                ", gender='" + gender + '\'' +
                '}';
    }

    public User(String user_id, String user_name, String avartar_url, String phone_number, String balance, String gender, String password) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.avartar_url = avartar_url;
        this.phone_number = phone_number;
        this.balance = balance;
        this.gender = gender;
        this.password = password;
    }
}

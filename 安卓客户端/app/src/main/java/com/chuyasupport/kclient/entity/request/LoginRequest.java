package com.chuyasupport.kclient.entity.request;

public class LoginRequest {
    private String phoneNumber;
    private String password;

    public String getUserName() {
        return phoneNumber;
    }

    public void setUserName(String userName) {
        this.phoneNumber = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginRequest(String userName, String password) {
        this.phoneNumber = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "userName='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

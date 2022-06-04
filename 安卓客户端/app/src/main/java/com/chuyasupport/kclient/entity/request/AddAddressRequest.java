package com.chuyasupport.kclient.entity.request;

public class AddAddressRequest {
    private String userName;
    private String gender;
    private String address;
    private String phoneNumber;
    private String userId;

    public String getUserId() {
        return userId;
    }

    public AddAddressRequest(String userName, String gender, String address, String phoneNumber, String userId) {
        this.userName = userName;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.userId = userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "AddAddressRequest{" +
                "userName='" + userName + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}

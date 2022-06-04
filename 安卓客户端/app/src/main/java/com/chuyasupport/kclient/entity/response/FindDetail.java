package com.chuyasupport.kclient.entity.response;

public class FindDetail {

    private String postId;
    private String getAddr;
    private String reward;
    private String packageSize;
    private String packageCode;
    private String address;
    private String userName;
    private String gender;
    private String phoneNumber;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getGetAddr() {
        return getAddr;
    }

    public void setGetAddr(String getAddr) {
        this.getAddr = getAddr;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public String getPackageSize() {
        return packageSize;
    }

    public void setPackageSize(String packageSize) {
        this.packageSize = packageSize;
    }

    public String getPackageCode() {
        return packageCode;
    }

    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "FindDetail{" +
                "postId='" + postId + '\'' +
                ", getAddr='" + getAddr + '\'' +
                ", reward='" + reward + '\'' +
                ", packageSize='" + packageSize + '\'' +
                ", packageCode='" + packageCode + '\'' +
                ", address='" + address + '\'' +
                ", userName='" + userName + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

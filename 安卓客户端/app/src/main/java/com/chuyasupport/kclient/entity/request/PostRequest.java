package com.chuyasupport.kclient.entity.request;

public class PostRequest {
    private String userId;
    private String packageCode;
    private String getAddr;
    private String addrId;
    private String packageSize;
    private String reward;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPackageCode() {
        return packageCode;
    }

    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }

    public String getGetAddr() {
        return getAddr;
    }

    public void setGetAddr(String getAddr) {
        this.getAddr = getAddr;
    }

    public String getAddrId() {
        return addrId;
    }

    public void setAddrId(String addrId) {
        this.addrId = addrId;
    }

    public String getPackageSize() {
        return packageSize;
    }

    public void setPackageSize(String packageSize) {
        this.packageSize = packageSize;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public PostRequest(String userId, String packageCode, String getAddr, String addrId, String packageSize, String reward) {
        this.userId = userId;
        this.packageCode = packageCode;
        this.getAddr = getAddr;
        this.addrId = addrId;
        this.packageSize = packageSize;
        this.reward = reward;
    }

    @Override
    public String toString() {
        return "PostRequest{" +
                "userId='" + userId + '\'' +
                ", packageCode='" + packageCode + '\'' +
                ", getAddr='" + getAddr + '\'' +
                ", addrId='" + addrId + '\'' +
                ", packageSize='" + packageSize + '\'' +
                ", reward='" + reward + '\'' +
                '}';
    }
}

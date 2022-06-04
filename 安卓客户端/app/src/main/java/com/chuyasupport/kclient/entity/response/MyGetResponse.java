package com.chuyasupport.kclient.entity.response;

import java.util.List;

public class MyGetResponse {

    private String status;
    private List<VmyGetListDTO> vmyGetList;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<VmyGetListDTO> getVmyGetList() {
        return vmyGetList;
    }

    public void setVmyGetList(List<VmyGetListDTO> vmyGetList) {
        this.vmyGetList = vmyGetList;
    }

    public static class VmyGetListDTO {
        private String userId;
        private String getAddr;
        private String packageCode;
        private String userName;
        private String phoneNumber;
        private String packageSize;
        private String reward;
        private String postId;
        private String address;
        private int status;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getGetAddr() {
            return getAddr;
        }

        public void setGetAddr(String getAddr) {
            this.getAddr = getAddr;
        }

        public String getPackageCode() {
            return packageCode;
        }

        public void setPackageCode(String packageCode) {
            this.packageCode = packageCode;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
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

        public String getPostId() {
            return postId;
        }

        public void setPostId(String postId) {
            this.postId = postId;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}

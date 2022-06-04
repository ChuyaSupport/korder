package com.chuyasupport.kclient.entity.response;

import java.util.List;

public class MyPostResponse {

    private String status;
    private List<VmyPostListDTO> vmyPostList;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<VmyPostListDTO> getVmyPostList() {
        return vmyPostList;
    }

    public void setVmyPostList(List<VmyPostListDTO> vmyPostList) {
        this.vmyPostList = vmyPostList;
    }

    public static class VmyPostListDTO {
        private String getAddr;
        private String packageCode;
        private String packageSize;
        private String reward;
        private String status;
        private String userName;
        private String address;
        private String phoneNumber;
        private String userId;
        private String postId;

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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
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

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getPostId() {
            return postId;
        }

        public void setPostId(String postId) {
            this.postId = postId;
        }

        @Override
        public String toString() {
            return "VmyPostListDTO{" +
                    "getAddr='" + getAddr + '\'' +
                    ", packageCode='" + packageCode + '\'' +
                    ", packageSize='" + packageSize + '\'' +
                    ", reward='" + reward + '\'' +
                    ", status='" + status + '\'' +
                    ", userName='" + userName + '\'' +
                    ", address='" + address + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    ", userId='" + userId + '\'' +
                    ", postId='" + postId + '\'' +
                    '}';
        }
    }
}

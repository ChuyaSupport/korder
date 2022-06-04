package com.chuyasupport.kclient.entity.response;

import java.util.List;

public class FindResponse {

    private int status;
    private List<VfindResponseListDTO> vfindResponseList;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<VfindResponseListDTO> getVfindResponseList() {
        return vfindResponseList;
    }

    public void setVfindResponseList(List<VfindResponseListDTO> vfindResponseList) {
        this.vfindResponseList = vfindResponseList;
    }

    public static class VfindResponseListDTO {
        private String postId;
        private String getAddr;
        private String packageSize;
        private String address;
        private String reward;

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

        public String getPackageSize() {
            return packageSize;
        }

        public void setPackageSize(String packageSize) {
            this.packageSize = packageSize;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getReward() {
            return reward;
        }

        public void setReward(String reward) {
            this.reward = reward;
        }

        @Override
        public String toString() {
            return "VfindResponseListDTO{" +
                    "postId='" + postId + '\'' +
                    ", getAddr='" + getAddr + '\'' +
                    ", packageSize='" + packageSize + '\'' +
                    ", address='" + address + '\'' +
                    ", reward='" + reward + '\'' +
                    '}';
        }
    }
}

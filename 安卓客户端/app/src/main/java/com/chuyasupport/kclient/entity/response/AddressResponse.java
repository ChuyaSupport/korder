package com.chuyasupport.kclient.entity.response;

import java.util.List;

public class AddressResponse {

    private int status;
    private List<AddressListDTO> addressList;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<AddressListDTO> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressListDTO> addressList) {
        this.addressList = addressList;
    }

    public static class AddressListDTO {
        private String addrId;
        private String gender;
        private String address;
        private String phoneNumber;
        private String userId;
        private String userName;

        public String getAddrId() {
            return addrId;
        }

        public void setAddrId(String addrId) {
            this.addrId = addrId;
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

        public String getUserId() {
            return userId;
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
    }
}

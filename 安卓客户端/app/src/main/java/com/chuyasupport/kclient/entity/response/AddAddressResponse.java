package com.chuyasupport.kclient.entity.response;

public class AddAddressResponse {
    private String status;

    @Override
    public String toString() {
        return "AddAddressResponse{" +
                "status='" + status + '\'' +
                '}';
    }

    public AddAddressResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

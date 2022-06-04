package com.chuyasupport.kclient.api;

import com.chuyasupport.kclient.entity.request.AddAddressRequest;
import com.chuyasupport.kclient.entity.request.LoginRequest;
import com.chuyasupport.kclient.entity.request.PostRequest;
import com.chuyasupport.kclient.entity.response.*;
import retrofit2.Call;
import retrofit2.http.*;

public interface API {
    @HTTP(method = "POST", path = "/login", hasBody = true)
    Call<LoginResponse> login(@Body LoginRequest loginRequest);

    @FormUrlEncoded
    @POST("/getAddress")
    Call<AddressResponse> getAddress(@Field("userId") String userId);

    @HTTP(method = "POST", path = "/addAddress", hasBody = true)
    Call<AddAddressResponse> addAddress(@Body AddAddressRequest addAddressRequest);

    @HTTP(method = "POST", path = "/find", hasBody = true)
    Call<FindResponse> getFindData();

    @FormUrlEncoded
    @POST("/findDetail")
    Call<FindDetail> getFindDetail(@Field("postId") String postId);

    @HTTP(method = "POST", path = "/post", hasBody = true)
    Call<PostResponse> post(@Body PostRequest postRequest);

    @FormUrlEncoded
    @POST("/receive")
    Call<GetReceiveResponse> getReceive(@Field("userId") String userId, @Field("postId") String postId);

    @FormUrlEncoded
    @POST("/myGet")
    Call<MyGetResponse> getMyGet(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("/getMyPost")
    Call<MyPostResponse> getMyPost(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("/confirm")
    Call<String> confirm(@Field("postId") String postId);
}

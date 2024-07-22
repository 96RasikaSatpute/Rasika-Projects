package com.miniproject.bhojanamv3.network;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Api {
    @POST("send")
    Call<ResponseBody> sendNotification(@Header("Authorization") String str, @Body RequestBody requestBody);
}

package com.miniproject.bhojanamv3.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    private static final String BASE_URL = "https://fcm.googleapis.com/fcm/";
    private static final OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        Retrofit build = new Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
        retrofit = build;
        return build;
    }
}

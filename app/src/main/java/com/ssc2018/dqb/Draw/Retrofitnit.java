package com.ssc2018.dqb.Draw;



import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 调用的公共类
 * Created by Administrator on 2017/4/7.
 */


public class Retrofitnit {

    private static final String BASE_URL = "http://f.apiplus.net/";

    private static GitHubService service;

    public static GitHubService getService() {
        if (service == null) {
            Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).
                    baseUrl(BASE_URL).build();
            service = retrofit.create(GitHubService.class);
        }
        return service;
    }
}

package com.ssc2018.dqb.Draw;

import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 定义上面的一个REST API接口。 该接口定义了一个函数 listRepos ,
 * 该函数会通过HTTP GET请求去访问服务器的/users/{user}/repos路径并把返回的结果封装为List<Repo> Java对象返回
 */
public interface GitHubService {

    /**
     * 首页的接口
     * //Homeget 是要接收后台给我的数据， route是要传递给后台的数据
     *
     * @return
     */
    @Headers({"Content-Type:application/x-www-form-urlencoded; charset=utf-8", "charset: utf-8"})
    @POST("pl3-20.json")
    Call<NetCommon<NetDatas>> getPl3();

    @POST("pl5-20.json")
    Call<NetCommon<NetDatas>> getPl5();

    @POST("ssq-20.json")
    Call<NetCommon<NetDatas>> getSsq();

    @POST("bj11x5-20.json")
    Call<NetCommon<NetDatas>> getBj11x5();

    @POST("fc3d-20.json")
    Call<NetCommon<NetDatas>> getFc3d();

    @POST("dlt-20.json")
    Call<NetCommon<NetDatas>> getDlt();



}

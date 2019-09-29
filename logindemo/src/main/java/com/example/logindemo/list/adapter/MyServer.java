package com.example.logindemo.list.adapter;


import com.example.logindemo.list.bean.DataBeans;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 华为 on 2019/7/23.
 */

public interface MyServer {
//https://slb-exam-test.ksbao.com/api/chapterMenu/getChapterMenuX?appEName=GJZC_ZG_QKYX_YTMJ&clientver=ying.ksbao.com&v=0.07988743734436099
    String path = "https://slb-exam-test.ksbao.com/";
    @GET("api/chapterMenu/getChapterMenuX?")
    Observable<DataBeans> getData(@Query("appEName") String appEName, @Query("clientver") String clientver, @Query("v") Double v);

}

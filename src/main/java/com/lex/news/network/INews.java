package com.lex.news.network;

import com.lex.news.data.model.WebResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 获取新闻接口
 * Created by lex on 2017/3/4.
 */

public interface INews {
    @GET("index")
    Call<WebResponse> getNews(@Query("type") String type, @Query("key") String key);
}

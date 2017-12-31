package com.lex.news.ui.home;

import android.util.Log;

import com.lex.news.network.Url;
import com.lex.news.data.model.WebResponse;
import com.lex.news.network.INews;
import com.lex.news.network.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 首页Presenter
 * Created by lex on 2017/3/5.
 */

public class HomePresenter implements HomeContract.Presenter {
    private static final String TAG = HomePresenter.class.getSimpleName();
    private HomeContract.View mView;

    public HomePresenter(HomeContract.View view) {
        if (view == null) return;
        mView = view;
        mView.setPresenter(this);
    }

    /**
     * 获取新闻消息
     */
    @Override
    public void getNews() {
        // 1、初始化Retrofit，得到INews动态代理对象
        INews service = NetworkService.getInstance().getRetrofit().create(INews.class);
        // 2、动态代理，生成OkHttpCall
        Call<WebResponse> newsCall = service.getNews(Url.TYPE_TOP, Url.APPKEY);

        Log.i(TAG, "start to send network message");

        // 3、利用OkHttp执行网络请求
        newsCall.enqueue(new Callback<WebResponse>() {
            @Override
            public void onResponse(Call<WebResponse> call, Response<WebResponse> response) {
                if (response == null || response.body() == null || response.body().result == null) return;

                mView.showNews(response.body().result.data);
                Log.i(TAG, "return: " + response.body().toString());
            }

            @Override
            public void onFailure(Call<WebResponse> call, Throwable t) {
                if (t == null) return;

                Log.e(TAG, "failed: " + t.toString());
            }
        });
    }
}

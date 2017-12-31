package com.lex.news.ui.home;

import com.lex.news.data.model.News;
import com.lex.news.ui.BasePresenter;
import com.lex.news.ui.BaseView;

import java.util.List;

/**
 * 首页契约类
 * Created by lex on 2017/3/5.
 */

public interface HomeContract {

    interface View extends BaseView<Presenter> {
        void showNews(List<News> newsList);
    }

    interface Presenter extends BasePresenter {
        void getNews();
    }
}

package com.lex.news.ui.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lex.news.widget.recyclerview.BaseAdapter;
import com.lex.news.ui.BaseFragment;
import com.lex.news.R;
import com.lex.news.data.model.News;
import com.lex.news.ui.home.adapter.NewsAdapter;

import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment implements HomeContract.View{
    private static final String TAG = HomeFragment.class.getSimpleName();
    @BindView(R.id.recycler_news)
    RecyclerView recyclerNews;
    private BaseAdapter mAdapter;
    private HomeContract.Presenter mPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.content_home;
    }

    /**
     * 初始化view
     */
    @Override
    protected void initView() {
        mAdapter = new NewsAdapter();
        recyclerNews.setAdapter(mAdapter);
        recyclerNews.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.getNews();
    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        if (presenter == null) return;
        mPresenter = presenter;
    }

    /**
     * show news data
     * @param newsList data
     */
    @Override
    public void showNews(List<News> newsList) {
        mAdapter.refreshData(newsList);
    }
}

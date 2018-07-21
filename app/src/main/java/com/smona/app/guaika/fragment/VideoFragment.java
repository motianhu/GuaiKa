package com.smona.app.guaika.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.smona.app.guaika.R;
import com.smona.app.guaika.adapter.VideoAdapter;
import com.smona.app.guaika.bean.VideoData;
import com.smona.app.guaika.mvpview.VideoMvpView;
import com.smona.app.guaika.presenter.VideoPresenter;
import com.smona.app.guaika.ui.recycler.CommonRecyclerView;
import com.smona.app.guaika.ui.recycler.SpacesItemDecoration;
import com.smona.app.guaika.util.UIUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.ittiger.player.PlayerManager;

public abstract class VideoFragment extends
        BaseFragment<SwipeRefreshLayout, List<VideoData>, VideoMvpView, VideoPresenter>
        implements VideoMvpView, CommonRecyclerView.LoadMoreListener {
    @BindView(R.id.contentView)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.video_recycler_view)
    CommonRecyclerView mRecyclerView;

    private View mFooterView;
    private VideoAdapter mVideoAdapter;

    @Override
    public View getContentView(LayoutInflater inflater, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, null);
        ButterKnife.bind(this, view);

        mRecyclerView.addItemDecoration(new SpacesItemDecoration(getResources().getDimensionPixelSize(R.dimen.d_10)));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setOnLoadMoreListener(this);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData(true);
            }
        });

        return view;
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        showLoading(pullToRefresh);
        presenter.refreshData(pullToRefresh);
    }

    @Override
    public void showLoadMoreErrorView() {
        if(mFooterView.getVisibility() == View.VISIBLE) {
            mFooterView.setVisibility(View.GONE);
        }
    }

    @Override
    public void showLoadMoreView() {
        if(mFooterView.getVisibility() == View.GONE) {
            mFooterView.setVisibility(View.VISIBLE);
        }
        UIUtil.showToast(mContext, mContext.getString(R.string.no_more_videos));
    }

    @Override
    public void setData(List<VideoData> data) {
        if (mVideoAdapter == null) {
            mVideoAdapter = new VideoAdapter(mContext, data);
            mVideoAdapter.enableFooterView();
            mFooterView = LayoutInflater.from(mContext).inflate(R.layout.footer_layout, mRecyclerView, false);
            mVideoAdapter.addFooterView(mFooterView);
            mRecyclerView.setAdapter(mVideoAdapter);
        } else {
            mVideoAdapter.addAll(data, 0);
        }
    }

    @Override
    public void setLoadMoreData(List<VideoData> videos) {
        mVideoAdapter.addAll(videos);
    }

    @Override
    public void onLoadMore() {
        showLoadMoreView();
        presenter.loadMoreData();
    }

    @Override
    public void showLoading(boolean pullToRefresh) {
        super.showLoading(pullToRefresh);
        if(pullToRefresh) {
            mSwipeRefreshLayout.setRefreshing(true);
        }
    }

    @Override
    public void showContent() {
        super.showContent();
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showError(Throwable e, boolean pullToRefresh) {
        super.showError(e, pullToRefresh);
        if(pullToRefresh) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mVideoAdapter = null;
        PlayerManager.getInstance().stop();
    }
}

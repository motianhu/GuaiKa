package com.smona.app.guaika.presenter;

import android.util.Log;

import com.smona.app.guaika.bean.IFengInfo;
import com.smona.app.guaika.bean.TabData;
import com.smona.app.guaika.factory.RetrofitFactory;
import com.smona.app.guaika.http.DataType;
import com.smona.app.guaika.util.DBManager;
import com.smona.app.guaika.util.DataKeeper;

import rx.Observable;

public class HomeVideoPresenter extends VideoPresenter {
    private TabData mTab;
    private static final int REFRESH_SIZE = 6;
    private static final int LOADMORE_SIZE = 20;

    public HomeVideoPresenter(TabData tab) {
        mTab = tab;
    }

    @Override
    public Observable<String> getHttpCallObservable(int curPage) {
        DataKeeper.saveCurrentTabId(mTab.getTabId());
        if(curPage == 1) {
            return RetrofitFactory.getVideoService().refreshVideos(mTab.getTabId(), REFRESH_SIZE, String.valueOf(System.currentTimeMillis()));
        } else if(curPage == 2){
            return RetrofitFactory.getVideoService().refreshVideos(mTab.getTabId(), LOADMORE_SIZE, "");
        } else {
            IFengInfo info = DBManager.getInstance().getSQLiteDB().queryOne(IFengInfo.class, "tabId=?", new String[]{String.valueOf(mTab.getTabId())});
            return RetrofitFactory.getVideoService().loadMoreVideos(mTab.getTabId(), LOADMORE_SIZE, info.getItemId());
        }
    }

    @Override
    public DataType getType() {
        return DataType.HOME;
    }
}

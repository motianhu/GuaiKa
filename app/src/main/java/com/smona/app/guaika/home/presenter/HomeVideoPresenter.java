package com.smona.app.guaika.home.presenter;

import com.smona.app.guaika.main.bean.IFengInfo;
import com.smona.app.guaika.main.bean.TabData;
import com.smona.app.guaika.home.factory.HomeRetrofitFactory;
import com.smona.app.guaika.main.http.DataType;
import com.smona.app.guaika.util.DBManager;
import com.smona.app.guaika.util.DataKeeper;

import rx.Observable;

public class HomeVideoPresenter extends VideoPresenter {
    private static final int REFRESH_SIZE = 6;
    private static final int LOADMORE_SIZE = 20;
    private TabData mTab;

    public HomeVideoPresenter(TabData tab) {
        mTab = tab;
    }

    @Override
    public Observable<String> getHttpCallObservable(int curPage) {
        DataKeeper.saveCurrentTabId(mTab.getTabId());
        if (curPage == 1) {
            return HomeRetrofitFactory.getVideoService().refreshVideos(mTab.getTabId(), REFRESH_SIZE, String.valueOf(System.currentTimeMillis()));
        } else if (curPage == 2) {
            return HomeRetrofitFactory.getVideoService().refreshVideos(mTab.getTabId(), LOADMORE_SIZE, "");
        } else {
            IFengInfo info = DBManager.getInstance().getSQLiteDB().queryOne(IFengInfo.class, "tabId=?", new String[]{String.valueOf(mTab.getTabId())});
            return HomeRetrofitFactory.getVideoService().loadMoreVideos(mTab.getTabId(), LOADMORE_SIZE, info.getItemId());
        }
    }

    @Override
    public DataType getType() {
        return DataType.HOME;
    }
}

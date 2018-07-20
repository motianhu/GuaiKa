package com.smona.app.guaika.presenter;

import com.smona.app.guaika.bean.IFengInfo;
import com.smona.app.guaika.factory.RetrofitFactory;
import com.smona.app.guaika.http.DataType;
import com.smona.app.guaika.util.DBManager;
import com.smona.app.guaika.util.DataKeeper;

import rx.Observable;

public class IFengVideoPresenter extends VideoPresenter {
    private int mTabId;
    private static final int REFRESH_SIZE = 6;
    private static final int LOADMORE_SIZE = 20;

    public IFengVideoPresenter(int tabId) {
        mTabId = tabId;
    }

    @Override
    public Observable<String> getHttpCallObservable(int curPage) {
        DataKeeper.saveCurrentTabId(mTabId);
        if(curPage == 1) {
            return RetrofitFactory.getIFengVideoService().refreshVideos(mTabId, REFRESH_SIZE, String.valueOf(System.currentTimeMillis()));
        } else if(curPage == 2){
            return RetrofitFactory.getIFengVideoService().refreshVideos(mTabId, LOADMORE_SIZE, "");
        } else {
            IFengInfo info = DBManager.getInstance().getSQLiteDB().queryOne(IFengInfo.class, "tabId=?", new String[]{String.valueOf(mTabId)});
            return RetrofitFactory.getIFengVideoService().loadMoreVideos(mTabId, LOADMORE_SIZE, info.getItemId());
        }
    }

    @Override
    public DataType getType() {
        return DataType.HOME;
    }
}

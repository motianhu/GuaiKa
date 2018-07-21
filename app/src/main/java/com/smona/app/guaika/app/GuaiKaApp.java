package com.smona.app.guaika.app;

import android.app.Application;

import com.smona.app.guaika.R;
import com.smona.app.guaika.util.ApplicationHelper;

import butterknife.ButterKnife;
import cn.ittiger.database.SQLiteDBConfig;
import cn.ittiger.player.Config;
import cn.ittiger.player.PlayerManager;
import cn.ittiger.player.factory.ExoPlayerFactory;

public class GuaiKaApp extends Application implements IDbApplication {
    /**
     * 本地数据库配置
     */
    private SQLiteDBConfig mDBConfig;

    @Override
    public void onCreate() {

        super.onCreate();

        //CrashHandler.getInstance().init(getApplicationContext());
        ApplicationHelper.getInstance().init(this);
        ButterKnife.setDebug(true);
        PlayerManager.loadConfig(
                new Config.Builder(this)
                        .enableSmallWindowPlay()
                        .cache(false)
                        .buildPlayerFactory(new ExoPlayerFactory(this))
                        .build()
        );
    }

    @Override
    public SQLiteDBConfig getGlobalDbConfig() {
        if (mDBConfig == null) {
            synchronized (GuaiKaApp.class) {
                if (mDBConfig == null) {
                    mDBConfig = new SQLiteDBConfig(getApplicationContext());
                    mDBConfig.setDbName(getResources().getString(R.string.db_name) + ".db");
                    //本地数据库文件保存在应用文件目录
                    mDBConfig.setDbDirectoryPath(getApplicationContext().getExternalCacheDir().getAbsolutePath());
                }
            }
        }
        return mDBConfig;
    }

    public void onDestroy() {
        ApplicationHelper.getInstance().onDestory();
        this.mDBConfig = null;
    }
}

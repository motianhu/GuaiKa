package com.smona.app.guaika.factory;

import android.os.Bundle;

import com.smona.app.guaika.bean.VideoTabData;
import com.smona.app.guaika.fragment.BaseFragment;
import com.smona.app.guaika.fragment.IFengTabFragment;
import com.smona.app.guaika.fragment.IFengVideoFragment;
import com.smona.app.guaika.http.DataType;

public class FragmentFactory {
    public static final String KEY_BUNDLE_TAB_ID = "tab_id";

    public static final BaseFragment createMainFragment(DataType type) {

        BaseFragment fragment = null;
        switch (type) {
            case IFENG:
                fragment = new IFengTabFragment();
                break;
        }
        return fragment;
    }

    public static final BaseFragment createTabItemFragment(DataType type, VideoTabData tabItem) {

        BaseFragment fragment = null;
        switch (type) {
            case IFENG:
                fragment = new IFengVideoFragment();
                break;
        }

        Bundle bundle = new Bundle();
        bundle.putInt(KEY_BUNDLE_TAB_ID, tabItem.getTabId());
        if(fragment != null) {
            fragment.setArguments(bundle);
        }

        return fragment;
    }
}

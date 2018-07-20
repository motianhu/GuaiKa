package com.smona.app.guaika.factory;

import android.os.Bundle;

import com.smona.app.guaika.bean.TabData;
import com.smona.app.guaika.fragment.BaseFragment;
import com.smona.app.guaika.fragment.TabFragment;
import com.smona.app.guaika.fragment.HomeVideoFragment;
import com.smona.app.guaika.http.DataType;

public class FragmentFactory {
    public static final String KEY_BUNDLE_TAB_ID = "tab_id";

    public static BaseFragment createTabFragment() {
        return new TabFragment();
    }

    public static BaseFragment createFragment(DataType type, TabData tabItem) {
        BaseFragment fragment = null;
        switch (type) {
            case HOME:
                fragment = new HomeVideoFragment();
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

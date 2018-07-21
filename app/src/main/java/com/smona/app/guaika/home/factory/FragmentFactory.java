package com.smona.app.guaika.home.factory;

import android.os.Bundle;

import com.smona.app.guaika.main.bean.TabData;
import com.smona.app.guaika.common.BaseFragment;
import com.smona.app.guaika.home.fragment.HomeVideoFragment;
import com.smona.app.guaika.main.fragment.TabFragment;
import com.smona.app.guaika.main.http.DataType;

public class FragmentFactory {
    public static final String KEY_BUNDLE_TAB_ITEM = "tab_item";

    public static BaseFragment createTabFragment() {
        return new TabFragment();
    }

    public static BaseFragment createFragment(DataType type, TabData tabItem) {
        BaseFragment fragment = null;
        switch (type) {
            case HOME:
                fragment = new HomeVideoFragment();
                break;
            case CATEGORY:
                fragment = new HomeVideoFragment();
                break;
        }

        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_BUNDLE_TAB_ITEM, tabItem);
        if (fragment != null) {
            fragment.setArguments(bundle);
        }

        return fragment;
    }
}

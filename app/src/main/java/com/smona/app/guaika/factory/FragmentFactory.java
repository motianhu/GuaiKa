package com.smona.app.guaika.factory;

import android.os.Bundle;

import com.smona.app.guaika.bean.TabData;
import com.smona.app.guaika.fragment.BaseFragment;
import com.smona.app.guaika.fragment.TabFragment;
import com.smona.app.guaika.fragment.HomeVideoFragment;
import com.smona.app.guaika.http.DataType;

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
        if(fragment != null) {
            fragment.setArguments(bundle);
        }

        return fragment;
    }
}
